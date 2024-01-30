package ingSoftware.laTienda.controlador;

import ingSoftware.laTienda.DTOs.StockDTO;
import ingSoftware.laTienda.modelo.Stock;
import ingSoftware.laTienda.servicio.StockServicio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class StockControlador {
    StockServicio stockServicio;
    public StockControlador(StockServicio stockServicio) {
        this.stockServicio = stockServicio;
    }
    @GetMapping("/stock")
    public List<StockDTO> buscarPorCodigoDeArticulo(@RequestParam Long codigo) {
        return stockServicio.buscarPorCodigoDeArticulo(codigo);
    }

    @GetMapping("/stockBySucursal")
    public List<StockDTO> buscarPorCodigoDeArticuloAndSucursal(@RequestParam Long codigoArticulo, @RequestParam Long legajoVendedor) {
        return stockServicio.buscarPorCodigoDeArticuloAndSucursal(codigoArticulo, legajoVendedor);
    }
    @GetMapping("/getAllstock")
    public List<Stock> getAllStock() {
        return stockServicio.getAllStock();
    }
}
