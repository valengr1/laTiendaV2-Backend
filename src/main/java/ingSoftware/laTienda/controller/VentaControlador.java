package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.DTOs.StockDTO;
import ingSoftware.laTienda.model.Cliente;
import ingSoftware.laTienda.model.LineaVenta;
import ingSoftware.laTienda.model.StockYCantidad;
import ingSoftware.laTienda.service.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class VentaControlador {
    VentaServicio ventaServicio;
    @Autowired
    public VentaControlador(VentaServicio ventaServicio) {
        this.ventaServicio = ventaServicio;
    }

    @PostMapping("/api/venta/registrarNuevaVenta")
    public String registrarNuevaVenta(@RequestBody List<StockYCantidad> stocksYCantidades, @RequestParam Long legajoVendedor, @RequestParam Long numeroDocumento){
        return ventaServicio.registrarNuevaVenta(stocksYCantidades, legajoVendedor,numeroDocumento);
    }
}
