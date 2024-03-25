package ingSoftware.laTienda.service;

import ingSoftware.laTienda.DTOs.StockYCantidad;
import ingSoftware.laTienda.model.*;
import ingSoftware.laTienda.model.Comprobante;
import ingSoftware.laTienda.repository.*;
import ingSoftware.laTienda.wsdl.*;
import ingSoftware.laTienda.wsdl.TipoDocumento;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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

    public ResponseEntity<?> registrar(List<StockYCantidad> stocksYCantidades, Long legajoVendedor, long numeroDocumento, String token) {
        try {
            Venta v = new Venta();
            Cliente cliente = buscarCliente(numeroDocumento);
            Vendedor vendedor = buscarVendedor(legajoVendedor);
            CondicionTributaria condicionTributariaTienda = vendedor.getPuntoVenta().getSucursal().getTienda().getCondicionTributaria();
            CondicionTributaria condicionTributariaCliente = cliente.getCondicionTributaria();
            Long numeroDocumentoCliente = cliente.getNumeroDocumento();
            Long idSucursal = vendedor.getPuntoVenta().getSucursal().getId();
            verificarStockSuficiente(stocksYCantidades, idSucursal);
            agregarLineasVenta(stocksYCantidades, idSucursal, v);
            double total = v.getTotal();
            double importeNeto = v.getImporteNeto(total);
            double importeIva = v.getImporteIva(total);
            SolicitarCaeResponse respuesta = solicitarAutorizacion(numeroDocumentoCliente, total, importeNeto, importeIva, token);
            if (respuesta.getSolicitarCaeResult().getValue().getError().getValue() != null) {
                throw new IllegalArgumentException(respuesta.getSolicitarCaeResult().getValue().getError().getValue());
            } else {
                actualizarStock(stocksYCantidades, idSucursal);
                formarVenta(cliente, vendedor, total, condicionTributariaCliente, condicionTributariaTienda, v);
                ventaRepositorio.save(v);
                return ResponseEntity.ok(v);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private void formarVenta(Cliente cliente, Vendedor vendedor, double total, CondicionTributaria condicionTributariaCliente, CondicionTributaria condicionTributariaTienda, Venta v) {
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.asignarPago(total);
        int ultimoNumeroComprobante = comprobanteRepositorio.obtenerUltimoNumeroComprobante();
        Comprobante comprobante = v.crearComprobante(ultimoNumeroComprobante + 1);
        comprobante.asignarTipoComprobante(condicionTributariaCliente, condicionTributariaTienda);
        v.setComprobante(comprobante);
    }

    private void agregarLineasVenta(List<StockYCantidad> stocksYCantidades, Long idSucursal, Venta v) {
        for (StockYCantidad stockYCantidad : stocksYCantidades) {
            Long idStock = stockYCantidad.getStockid();
            Stock stock = stockRepositorio.findStockByIdAndSucursalId(idStock, idSucursal);
            if (stock == null) {
                throw new IllegalArgumentException("No se encontró el stock con id: " + idStock + " en la sucursal con id: " + idSucursal);
            }
            v.agregarLineaVenta(stock, stockYCantidad.getCantidadRequerida());
        }
    }

    public Cliente buscarCliente(Long numeroDocumento) {
        Cliente cliente = clienteRepositorio.findCliente(numeroDocumento);
        if (cliente == null) {
            throw new IllegalArgumentException("No se encontró el cliente con el número de documento: " + numeroDocumento);
        }
        return cliente;
    }

    public Vendedor buscarVendedor(Long legajoVendedor) {
        Vendedor vendedor = vendedorRepositorio.findByLegajo(legajoVendedor);
        if (vendedor == null) {
            throw new IllegalArgumentException("No se encontró el vendedor con el legajo: " + legajoVendedor);
        }
        return vendedor;
    }

    public void verificarStockSuficiente(List<StockYCantidad> stocksYCantidades, Long idSucursal) {
        for (StockYCantidad stockYCantidad : stocksYCantidades) {
            Long idStock = stockYCantidad.getStockid();
            Stock stock = stockRepositorio.findStockByIdAndSucursalId(idStock, idSucursal);
            if (stock != null) {
                if (stock.getCantidad() < stockYCantidad.getCantidadRequerida()) {
                    throw new IllegalArgumentException("No hay stock suficiente para el artículo con id: " + idStock);
                }
            } else {
                throw new IllegalArgumentException("No se encontró el stock con id: " + idStock + " en la sucursal con id: " + idSucursal);
            }
        }
    }

    public void actualizarStock(List<StockYCantidad> stocksYCantidades, Long idSucursal) {
        for (StockYCantidad stockYCantidad : stocksYCantidades) {
            Long idStock = stockYCantidad.getStockid();
            int cantidadRequerida = stockYCantidad.getCantidadRequerida();
            Stock stock = stockRepositorio.findStockByIdAndSucursalId(idStock, idSucursal);
            if (stock == null) {
                throw new IllegalArgumentException("No se encontró el stock con id: " + idStock + " en la sucursal con id: " + idSucursal);
            }
            stockRepositorio.actualizarStock(idStock, cantidadRequerida, idSucursal);
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
        solicitudAutorizacion.setTipoComprobante(ingSoftware.laTienda.wsdl.TipoComprobante.FacturaB);
        solicitudAutorizacion.setTipoDocumento(TipoDocumento.Dni);
        SolicitarCaeResponse solicitarCaeResponse = autorizacionAFIPServicio.solicitarCae(token, solicitudAutorizacion);
        return solicitarCaeResponse;
    }


}
