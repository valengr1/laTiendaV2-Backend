package ingSoftware.laTienda.service;

import ingSoftware.laTienda.DTOs.StockDTO;
import ingSoftware.laTienda.model.Stock;
import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.repository.StockRepositorio;
import ingSoftware.laTienda.repository.VendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServicio {
    StockRepositorio stockRepositorio;
    VendedorRepositorio vendedorRepositorio;
    @Autowired
    public StockServicio(StockRepositorio stockRepositorio, VendedorRepositorio vendedorRepositorio) {
        this.stockRepositorio = stockRepositorio;
        this.vendedorRepositorio = vendedorRepositorio;
    }
//    public List<StockDTO> buscarPorCodigoDeArticulo(Long codigo) {
//        List<StockDTO> stocksDto = new ArrayList<>();
//        List<Stock> stocksEncontrados = stockRepositorio.findByCodigoDelArticulo(codigo);
//        return getStockDTOS(stocksDto, stocksEncontrados);
//    }

    public List<Stock> getAllStock() {
        return stockRepositorio.findAll();
    }

    public List<StockDTO> buscarPorCodigoDeArticuloAndSucursal(Long codigo, Long legajoVendedor) {
        List<StockDTO> stocksDto = new ArrayList<>();
        Vendedor v = vendedorRepositorio.findByLegajo(legajoVendedor);
        Long sucursalId = v.getSucursal().getId();
        List<Stock> stocksEncontrados = stockRepositorio.findStockByCodigoDelArticuloAndSucursalId(codigo, sucursalId);
        return getStockDTOS(stocksDto, stocksEncontrados);
    }

    private List<StockDTO> getStockDTOS(List<StockDTO> stocksDto, List<Stock> stocksEncontrados) {
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
}
