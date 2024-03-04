package ingSoftware.laTienda.controller;
import ingSoftware.laTienda.model.StockYCantidad;
import ingSoftware.laTienda.service.AutorizacionAFIPServicio;
import ingSoftware.laTienda.service.VentaServicio;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacionResponse;
import ingSoftware.laTienda.wsdl.SolicitarUltimosComprobantesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class VentaControlador {
    VentaServicio ventaServicio;
    AutorizacionAFIPServicio autorizacionAFIPServicio;
    @Autowired
    public VentaControlador(VentaServicio ventaServicio, AutorizacionAFIPServicio autorizacionAFIPServicio) {
        this.ventaServicio = ventaServicio;
        this.autorizacionAFIPServicio = autorizacionAFIPServicio;
    }

    @GetMapping("api/venta/solicitarToken")
    public SolicitarAutorizacionResponse solicitarToken(){
        return autorizacionAFIPServicio.solicitarAutorizacion("222D6106-B8FA-4F08-B0E6-A2E89AE02247");
    }

    @GetMapping("/api/venta/solicitarUltimosComprobantes")
    public SolicitarUltimosComprobantesResponse solicitarUltimosComprobantes(){
        String token = solicitarToken().getSolicitarAutorizacionResult().getValue().getToken().getValue();
        return autorizacionAFIPServicio.solicitarUltimosComprobantes(token);
    }

    @PostMapping("/api/venta/registrarNuevaVenta")
    public String registrarNuevaVenta(@RequestBody List<StockYCantidad> stocksYCantidades, @RequestParam long legajoVendedor, @RequestParam long numeroDocumento) throws DatatypeConfigurationException {
        String token = solicitarToken().getSolicitarAutorizacionResult().getValue().getToken().getValue();
        return ventaServicio.registrarNuevaVenta(stocksYCantidades, legajoVendedor,numeroDocumento, token);
    }
}
