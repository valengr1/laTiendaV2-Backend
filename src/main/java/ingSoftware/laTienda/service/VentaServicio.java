package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.*;
import ingSoftware.laTienda.repository.ClienteRepositorio;
import ingSoftware.laTienda.repository.StockRepositorio;
import ingSoftware.laTienda.repository.VendedorRepositorio;
import ingSoftware.laTienda.repository.VentaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service @Transactional
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
        if(cliente == null) {
            return "No se encontró el cliente";
        } else if (vendedor == null) {
            return "No se encontró el vendedor";
        } else if (stocksYCantidades.isEmpty()){
            return "No hay productos en la venta";
        } else {
            //compruebo que haya stock suficiente
            for(StockYCantidad stockYCantidad : stocksYCantidades) {
                Stock stock = stockRepositorio.findStockByIdAndSucursalId(stockYCantidad.getStockid(), vendedor.getSucursal().getId());
                if (stock.getCantidad() - stockYCantidad.getCantidadRequerida() < 0) {
                    return "No hay stock suficiente";
                }
            }
            //Hay stock suficiente. Agrego las lineas de venta y actualizo el stock.
            for(StockYCantidad stockYCantidad : stocksYCantidades) {
                Stock stock = stockRepositorio.findStockByIdAndSucursalId(stockYCantidad.getStockid(), vendedor.getSucursal().getId());
                v.agregarLineaVenta(stock, stockYCantidad.getCantidadRequerida());
                stockRepositorio.actualizarStock(stock.getId(), stockYCantidad.getCantidadRequerida(), vendedor.getSucursal().getId());
            }
            v.setCliente(cliente);
            v.setVendedor(vendedor);
            v.asociarTipoComprobante(cliente);
            Pago p = v.crearPago(v.getTotal());
            v.setPago(p);
            LocalDateTime fecha = LocalDateTime.now();
            v.setFecha(fecha);
            PuntoVenta puntoVenta = new PuntoVenta();
            puntoVenta.setId(1L);
            v.setPuntoVenta(puntoVenta);
            ventaRepositorio.save(v);
            return "Venta registrada con éxito";
        }
    }
}
