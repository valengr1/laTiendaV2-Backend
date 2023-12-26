package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.modelo.Stock;
import ingSoftware.laTienda.repositorio.StockRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServicio {
    StockRepositorio stockRepositorio;
    public StockServicio(StockRepositorio stockRepositorio) {
        this.stockRepositorio = stockRepositorio;
    }
    public List<Stock> buscarPorCodigoDeArticulo(Long codigo) {
        return stockRepositorio.findByCodigoDelArticulo(codigo);
    }

}
