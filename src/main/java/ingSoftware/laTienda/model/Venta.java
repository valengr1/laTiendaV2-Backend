package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column @Getter @Setter
    private LocalDateTime fecha;
    @ManyToOne @JoinColumn(nullable = false)  @Setter
    private PuntoVenta puntoVenta;
    @ManyToOne @JoinColumn(nullable = false) @Setter
    private Vendedor vendedor;
    @ManyToOne @JoinColumn(nullable = false) @Setter
    private Cliente cliente;
    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL) @Setter
    private Pago pago; //venta debe crearlo? como diferenciar pagos en efectivo o tarjeta?
    @Enumerated(EnumType.STRING)
    private TipoComprobante tipoComprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta") @Setter
    private List<LineaVenta> lineasVenta = new ArrayList<>();

    public void agregarLineaVenta(Stock stock, int cantidadRequerida) {
        LineaVenta lineaVenta = new LineaVenta();
        lineaVenta.setCantidad(cantidadRequerida);
        lineaVenta.setStock(stock);
        lineaVenta.setVenta(this);
        lineasVenta.add(lineaVenta);
    }

    public Pago crearPago(Double monto){
        Pago pago = new Pago();
        pago.setMonto(monto);
        pago.setVenta(this);
        return pago;
    }

    public void asociarTipoComprobante(Cliente cliente) {
        if(cliente.getCondicionTributaria().getId() >= 1 && cliente.getCondicionTributaria().getId() <= 5){
            if(cliente.getCondicionTributaria().getId() == 1 || cliente.getCondicionTributaria().getId() == 2){
                tipoComprobante = TipoComprobante.FACTURA_A;
            } else {
                tipoComprobante = TipoComprobante.FACTURA_B;
            }
        } else {
            throw new IllegalArgumentException(String.valueOf(cliente.getCondicionTributaria().getId()));
        }
    }

    public Double getTotal(){
        Double total = 0.0;
        for(LineaVenta lv : lineasVenta){
            total += lv.calcularSubtotal();
        }
        return total;
    }
}
