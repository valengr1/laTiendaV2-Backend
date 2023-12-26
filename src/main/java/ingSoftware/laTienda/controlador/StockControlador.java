package ingSoftware.laTienda.controlador;

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
    public List<Stock> buscarPorCodigoDeArticulo(@RequestParam Long codigo) {
        return stockServicio.buscarPorCodigoDeArticulo(codigo);
    }
}
