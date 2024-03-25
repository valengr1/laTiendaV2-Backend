package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.DTOs.StockYCantidad;
import ingSoftware.laTienda.model.Venta;
import ingSoftware.laTienda.service.AutorizacionAFIPServicio;
import ingSoftware.laTienda.service.VentaServicio;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacionResponse;
import ingSoftware.laTienda.wsdl.SolicitarUltimosComprobantesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class VentaControlador {
    VentaServicio ventaServicio;
    AutorizacionAFIPServicio autorizacionAFIPServicio;

    @Autowired
    public VentaControlador(VentaServicio ventaServicio, AutorizacionAFIPServicio autorizacionAFIPServicio) {
        this.ventaServicio = ventaServicio;
        this.autorizacionAFIPServicio = autorizacionAFIPServicio;
    }

    @PostMapping("api/ventas/solicitarToken")
    public SolicitarAutorizacionResponse solicitarToken() {
        return autorizacionAFIPServicio.solicitarAutorizacion("222D6106-B8FA-4F08-B0E6-A2E89AE02247");
    }

    @PostMapping("/api/ventas/solicitarUltimosComprobantes")
    public SolicitarUltimosComprobantesResponse solicitarUltimosComprobantes() {
        String token = solicitarToken().getSolicitarAutorizacionResult().getValue().getToken().getValue();
        return autorizacionAFIPServicio.solicitarUltimosComprobantes(token);
    }

    @PostMapping("/api/ventas/{legajoVendedor}/{numeroDocumentoCliente}")
    public ResponseEntity<?> registrarNuevaVenta(@RequestBody List<StockYCantidad> stocksYCantidades, @PathVariable long legajoVendedor, @PathVariable long numeroDocumentoCliente) {
        System.out.println(stocksYCantidades);
        System.out.println(legajoVendedor);
        System.out.println(numeroDocumentoCliente);
        String token = solicitarToken().getSolicitarAutorizacionResult().getValue().getToken().getValue();
        return ventaServicio.registrar(stocksYCantidades, legajoVendedor, numeroDocumentoCliente, token);
    }
}
