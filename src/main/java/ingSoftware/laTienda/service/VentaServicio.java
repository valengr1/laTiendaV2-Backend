package ingSoftware.laTienda.service;

import ingSoftware.laTienda.DTOs.StockYCantidad;
import ingSoftware.laTienda.model.*;
import ingSoftware.laTienda.model.Comprobante;
import ingSoftware.laTienda.repository.*;
import ingSoftware.laTienda.wsdl.*;
import ingSoftware.laTienda.wsdl.TipoComprobante;
import ingSoftware.laTienda.wsdl.TipoDocumento;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
public class VentaServicio {
    VentaRepositorio ventaRepositorio;
    ClienteRepositorio clienteRepositorio;
    VendedorRepositorio vendedorRepositorio;
    StockRepositorio stockRepositorio;
    ComprobanteRepositorio comprobanteRepositorio;
    AutorizacionAFIPServicio autorizacionAFIPServicio;

    @Autowired
    public VentaServicio(VentaRepositorio ventaRepositorio, ClienteRepositorio clienteRepositorio, VendedorRepositorio vendedorRepositorio, StockRepositorio stockRepositorio, AutorizacionAFIPServicio autorizacionAFIPServicio, ComprobanteRepositorio comprobanteRepositorio) {
        this.ventaRepositorio = ventaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.vendedorRepositorio = vendedorRepositorio;
        this.stockRepositorio = stockRepositorio;
        this.autorizacionAFIPServicio = autorizacionAFIPServicio;
        this.comprobanteRepositorio = comprobanteRepositorio;
    }

    public String registrar(List<StockYCantidad> stocksYCantidades, Long legajoVendedor, long numeroDocumento, String token) {
        Venta v = new Venta();
        Cliente cliente = clienteRepositorio.findCliente(numeroDocumento);
        String condicionTributariaCliente = cliente.getCondicionTributaria().getDescripcion();
        Vendedor vendedor = vendedorRepositorio.findByLegajo(legajoVendedor);
        for (StockYCantidad stockYCantidad : stocksYCantidades) {
            Stock stock = stockRepositorio.findStockByIdAndSucursalId(stockYCantidad.getStockid(), vendedor.getPuntoVenta().getSucursal().getId());
            v.agregarLineaVenta(stock, stockYCantidad.getCantidadRequerida());
        }
        double total = v.getTotal();
        double importeNeto = total - (total * 0.21);
        double importeIva = total * 0.21;
        double totalRedondeado = redondearDecimales(total, 2);
        double importeNetoRedondeado = redondearDecimales(importeNeto, 2);
        double importeIvaRedondeado = redondearDecimales(importeIva, 2);
        try {
            SolicitarCaeResponse respuesta = solicitarAutorizacion(numeroDocumento, totalRedondeado, importeNetoRedondeado, importeIvaRedondeado, token);
            if (respuesta.getSolicitarCaeResult().getValue().getError().getValue() != null) {
                return respuesta.getSolicitarCaeResult().getValue().getError().getValue();
            } else {
                for (StockYCantidad stockYCantidad : stocksYCantidades) {
                    Stock stock = stockRepositorio.findStockByIdAndSucursalId(stockYCantidad.getStockid(), vendedor.getPuntoVenta().getSucursal().getId());
                    if (stock != null) {
                        if (stock.getCantidad() < stockYCantidad.getCantidadRequerida()) {
                            return "No hay stock suficiente";
                        } else {
                            stockRepositorio.actualizarStock(stock.getId(), stockYCantidad.getCantidadRequerida(), vendedor.getPuntoVenta().getSucursal().getId());
                        }
                    } else{
                        return "No se encontró el stock";
                    }
                }
                v.setCliente(cliente);
                v.setVendedor(vendedor);
                Pago p = v.crearPago(total);
                v.setPago(p);
                LocalDateTime fecha = LocalDateTime.now();
                v.setFecha(fecha);
                int ultimoNumeroComprobante = comprobanteRepositorio.obtenerUltimoNumeroComprobante();
                Comprobante comprobante = v.crearComprobante(condicionTributariaCliente, ultimoNumeroComprobante + 1);
                v.setComprobante(comprobante);
                ventaRepositorio.save(v);
                return "Venta registrada con éxito";
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return "Error al registrar la venta";
    }

    public SolicitarCaeResponse solicitarAutorizacion(long numeroDocumento, double importeTotal, double importeNeto, double importeIva, String token) throws DatatypeConfigurationException {
        GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
        XMLGregorianCalendar fechaSolicitud = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<XMLGregorianCalendar> fechaJaxb = factory.createSolicitudAutorizacionFecha(fechaSolicitud);
        long numero = 1;
        SolicitudAutorizacion solicitudAutorizacion = new SolicitudAutorizacion();
        solicitudAutorizacion.setFecha(fechaJaxb);
        solicitudAutorizacion.setImporteIva(importeIva);
        solicitudAutorizacion.setImporteNeto(importeNeto);
        solicitudAutorizacion.setImporteTotal(importeTotal);
        solicitudAutorizacion.setNumero(numero);
        solicitudAutorizacion.setNumeroDocumento(numeroDocumento);
        solicitudAutorizacion.setTipoComprobante(TipoComprobante.FacturaB);
        solicitudAutorizacion.setTipoDocumento(TipoDocumento.Dni);
        SolicitarCaeResponse solicitarCaeResponse = autorizacionAFIPServicio.solicitarCae(token, solicitudAutorizacion);
        return solicitarCaeResponse;
    }

    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
}
