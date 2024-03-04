package ingSoftware.laTienda.service;

import ingSoftware.laTienda.controller.AutorizacionAFIPControlador;
import ingSoftware.laTienda.controller.VentaControlador;
import ingSoftware.laTienda.model.*;
import ingSoftware.laTienda.repository.ClienteRepositorio;
import ingSoftware.laTienda.repository.StockRepositorio;
import ingSoftware.laTienda.repository.VendedorRepositorio;
import ingSoftware.laTienda.repository.VentaRepositorio;
import ingSoftware.laTienda.wsdl.*;
import ingSoftware.laTienda.wsdl.TipoComprobante;
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

@Service @Transactional
public class VentaServicio {
    VentaRepositorio ventaRepositorio;
    ClienteRepositorio clienteRepositorio;
    VendedorRepositorio vendedorRepositorio;
    StockRepositorio stockRepositorio;
    AutorizacionAFIPServicio autorizacionAFIPServicio;

    @Autowired
    public VentaServicio(VentaRepositorio ventaRepositorio , ClienteRepositorio clienteRepositorio, VendedorRepositorio vendedorRepositorio, StockRepositorio stockRepositorio, AutorizacionAFIPServicio autorizacionAFIPServicio) {
        this.ventaRepositorio = ventaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.vendedorRepositorio = vendedorRepositorio;
        this.stockRepositorio = stockRepositorio;
        this.autorizacionAFIPServicio = autorizacionAFIPServicio;
    }

    public String registrarNuevaVenta( List<StockYCantidad> stocksYCantidades, Long legajoVendedor, long numeroDocumento, String token){
        Venta v = new Venta();
        Cliente cliente = clienteRepositorio.findClienteByDNI(numeroDocumento);
        Vendedor vendedor = vendedorRepositorio.findByLegajo(legajoVendedor);
        if(cliente == null) {
            return "No se encontró el cliente";
        } else if (vendedor == null) {
            return "No se encontró el vendedor";
        } else if (stocksYCantidades.isEmpty()){
            return "No hay productos en la venta";
        } else {
            for(StockYCantidad stockYCantidad : stocksYCantidades) {
                Stock stock = stockRepositorio.findStockByIdAndSucursalId(stockYCantidad.getStockid(), vendedor.getSucursal().getId());
                if (stock.getCantidad() - stockYCantidad.getCantidadRequerida() < 0) {
                    return "No hay stock suficiente";
                }
            }
            for(StockYCantidad stockYCantidad : stocksYCantidades) {
                Stock stock = stockRepositorio.findStockByIdAndSucursalId(stockYCantidad.getStockid(), vendedor.getSucursal().getId());
                v.agregarLineaVenta(stock, stockYCantidad.getCantidadRequerida());
                //stockRepositorio.actualizarStock(stock.getId(), stockYCantidad.getCantidadRequerida(), vendedor.getSucursal().getId());
            }
            double total = v.getTotal();
            double importeNeto = total - (total * 0.21);
            double importeIva = total * 0.21;
            double totalRedondeado = redondearDecimales(total,2);
            double importeNetoRedondeado = redondearDecimales(importeNeto,2);
            double importeIvaRedondeado = redondearDecimales(importeIva,2);
            try {
                SolicitarCaeResponse respuesta =  solicitarAutorizacion(numeroDocumento, totalRedondeado, importeNetoRedondeado, importeIvaRedondeado, token);
                System.out.println(respuesta.getSolicitarCaeResult().getValue().getError().getValue());
                if(respuesta.getSolicitarCaeResult().getValue().getError().getValue() != null){
                    return "Error al solicitar CAE";
                }
            } catch (Exception e) {
                e.getMessage();
            }
            v.setCliente(cliente);
            v.setVendedor(vendedor);
            v.asociarTipoComprobante(cliente);
            Pago p = v.crearPago(total);
            v.setPago(p);
            LocalDateTime fecha = LocalDateTime.now();
            v.setFecha(fecha);
            PuntoVenta puntoVenta = new PuntoVenta();
            puntoVenta.setId(1L);
            v.setPuntoVenta(puntoVenta);
            //ventaRepositorio.save(v);
            return "Venta registrada con éxito";
        }
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
        solicitudAutorizacion.setTipoComprobante(TipoComprobante.FACTURA_B);
        solicitudAutorizacion.setTipoDocumento(TipoDocumento.DNI);
        return autorizacionAFIPServicio.solicitarCae(token, solicitudAutorizacion);
    }
    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
}
