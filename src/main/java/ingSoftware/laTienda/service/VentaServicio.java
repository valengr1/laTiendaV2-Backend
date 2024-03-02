package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.*;
import ingSoftware.laTienda.repository.ClienteRepositorio;
import ingSoftware.laTienda.repository.StockRepositorio;
import ingSoftware.laTienda.repository.VendedorRepositorio;
import ingSoftware.laTienda.repository.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaServicio {
    VentaRepositorio ventaRepositorio;
    ClienteRepositorio clienteRepositorio;
    VendedorRepositorio vendedorRepositorio;
    StockRepositorio stockRepositorio;

    @Autowired
    public VentaServicio(VentaRepositorio ventaRepositorio , ClienteRepositorio clienteRepositorio, VendedorRepositorio vendedorRepositorio, StockRepositorio stockRepositorio) {
        this.ventaRepositorio = ventaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.vendedorRepositorio = vendedorRepositorio;
        this.stockRepositorio = stockRepositorio;
    }
    public String registrarNuevaVenta( List<StockYCantidad> stocksYCantidades, Long legajoVendedor, Long numeroDocumento) {
        Venta v = new Venta();
        Cliente cliente = clienteRepositorio.findClienteByDNI(numeroDocumento);
        Vendedor vendedor = vendedorRepositorio.findByLegajo(legajoVendedor);
        for(StockYCantidad stockYCantidad : stocksYCantidades){
            Stock stock = stockRepositorio.findByIdStock(stockYCantidad.getStockid());
            v.agregarLineaVenta(stock,stockYCantidad.getCantidadRequerida());
        }
        LocalDateTime fecha = LocalDateTime.now();
        v.setFecha(fecha);
        PuntoVenta puntoVenta = new PuntoVenta();
        puntoVenta.setId(1L);
        v.setPuntoVenta(puntoVenta);
        v.setVendedor(vendedor);
        v.setCliente(cliente);
        v.crearTipoComprobante(cliente);
        Pago p = v.crearPago(v.getTotal());
        v.setPago(p);
        ventaRepositorio.save(v);
        return "Venta registrada con éxito";
    }
}
