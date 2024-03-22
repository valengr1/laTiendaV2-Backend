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
    private LocalDateTime fecha = LocalDateTime.now();

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
        if(stock == null || cantidadRequerida <= 0){
            throw new IllegalArgumentException("El stock y la cantidad requerida son obligatorios");
        }
        LineaVenta lineaVenta = new LineaVenta();
        lineaVenta.setCantidad(cantidadRequerida);
        lineaVenta.setStock(stock);
        lineaVenta.setVenta(this);
        lineasVenta.add(lineaVenta);
    }

    public void asignarPago(Double monto) {
        if(monto == null || monto <= 0){
            throw new IllegalArgumentException("El monto es obligatorio y debe ser mayor a 0");
        }
        Pago pago = new Pago();
        pago.setMonto(monto);
        pago.setVenta(this);
        this.setPago(pago);
    }

    public Comprobante crearComprobante(int numeroComprobante){
        if(comprobante == null || numeroComprobante <= 0){
            throw new IllegalArgumentException("El tipo de comprobante y el número de comprobante son obligatorios");
        }
        Comprobante comprobante = new Comprobante();
        comprobante.setNumero(numeroComprobante);
        comprobante.setVenta(this);
        return comprobante;
    }

    public Double getTotal() {
        Double total = 0.0;
        if(lineasVenta == null || lineasVenta.isEmpty()){
            throw new IllegalArgumentException("La venta debe tener al menos una línea de venta");
        }
        for (LineaVenta lv : lineasVenta) {
            total += lv.calcularSubtotal();
        }
        double totalRedondeado = redondearDecimales(total, 2);
        return totalRedondeado;
    }

    public Double getImporteNeto(double total){
        double importeNeto = total - (total * 0.21);
        double importeNetoRedondeado = redondearDecimales(importeNeto, 2);
        return importeNetoRedondeado;
    }

    public Double getImporteIva(double total){
        double importeIva = total * 0.21;
        double importeIvaRedondeado = redondearDecimales(importeIva, 2);
        return importeIvaRedondeado;
    }

    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
}
