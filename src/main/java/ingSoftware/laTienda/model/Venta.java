package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column @Getter @Setter
    private LocalDateTime fecha;

    @ManyToOne @JoinColumn(nullable = false) @Setter
    private Vendedor vendedor;

    @ManyToOne @JoinColumn(nullable = false) @Setter
    private Cliente cliente;

    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL) @Setter
    private Pago pago;

    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL) @Setter
    private Comprobante comprobante;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta") @Setter
    private List<LineaVenta> lineasVenta = new ArrayList<>();

    public void agregarLineaVenta(Stock stock, int cantidadRequerida) {
        LineaVenta lineaVenta = new LineaVenta();
        lineaVenta.setCantidad(cantidadRequerida);
        lineaVenta.setStock(stock);
        lineaVenta.setVenta(this);
        lineasVenta.add(lineaVenta);
    }

    public Pago crearPago(Double monto) {
        Pago pago = new Pago();
        pago.setMonto(monto);
        pago.setVenta(this);
        pago.setFecha(LocalDateTime.now());
        return pago;
    }

    public Comprobante crearComprobante(String condicionTributariaCliente, int numeroComprobante){
        Comprobante comprobante = new Comprobante();
        LocalDateTime fecha = LocalDateTime.now();
        comprobante.setFecha(fecha);
        comprobante.setDescripcion("Factura");
        if(condicionTributariaCliente.equals("Monotributo")  || condicionTributariaCliente.equals("Responsable Inscripto") ){
            comprobante.setTipoComprobante(TipoComprobante.FACTURA_A);
        }else{
            comprobante.setTipoComprobante(TipoComprobante.FACTURA_B);
        }
        comprobante.setNumero(numeroComprobante);
        comprobante.setVenta(this);
        return comprobante;
    }

    public Double getTotal() {
        Double total = 0.0;
        for (LineaVenta lv : lineasVenta) {
            total += lv.calcularSubtotal();
        }
        return total;
    }
}
