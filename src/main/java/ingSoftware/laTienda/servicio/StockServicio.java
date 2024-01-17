package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.DTOs.StockDTO;
import ingSoftware.laTienda.modelo.Stock;
import ingSoftware.laTienda.repositorio.StockRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServicio {
    StockRepositorio stockRepositorio;
    public StockServicio(StockRepositorio stockRepositorio) {
        this.stockRepositorio = stockRepositorio;
    }
    public List<StockDTO> buscarPorCodigoDeArticulo(Long codigo) {
        List<StockDTO> stocksDto = new ArrayList<>();
        List<Stock> stocksEncontrados = stockRepositorio.findByCodigoDelArticulo(codigo);
        for (Stock stock : stocksEncontrados) {
            StockDTO stockDto = new StockDTO();
            stockDto.setId(stock.getId());
            stockDto.setTalle(stock.getTalle().getDescripcion());
            stockDto.setColor(stock.getColor().getDescripcion());
            stockDto.setCantidadDisponible(stock.getCantidad());
            stockDto.setPrecioVenta(stock.getArticulo().getPrecio());
            stockDto.setDescripcionArticulo(stock.getArticulo().getDescripcion());
            stockDto.setMarca(stock.getArticulo().getMarca().getDescripcion());
            stocksDto.add(stockDto);
        }
        return stocksDto;
    }

    public List<Stock> getAllStock() {
        return stockRepositorio.findAll();
    }

}
