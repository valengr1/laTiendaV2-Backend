package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.DTOs.StockDTO;
import ingSoftware.laTienda.model.Stock;
import ingSoftware.laTienda.service.StockServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class StockControlador {
    StockServicio stockServicio;
    public StockControlador(StockServicio stockServicio) {
        this.stockServicio = stockServicio;
    }
//    @GetMapping("/api/stock")
//    public List<StockDTO> buscarPorCodigoDeArticulo(@RequestParam Long codigo) {
//        return stockServicio.buscarPorCodigoDeArticulo(codigo);
//    }

    @GetMapping("/api/stocks/{codigoArticulo}/{legajoVendedor}")
    public List<StockDTO> buscarPorCodigoDeArticuloAndSucursal(@PathVariable Long codigoArticulo, @PathVariable Long legajoVendedor) {
        return stockServicio.buscarPorCodigoDeArticuloAndSucursal(codigoArticulo, legajoVendedor);
    }
    @GetMapping("/api/stocks")
    public List<Stock> getAllStock() {
        return stockServicio.getAllStock();
    }
}
