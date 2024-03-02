package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @AllArgsConstructor @NoArgsConstructor @ToString
public class LineaVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) @Getter @Setter
    private int cantidad;
    @ManyToOne @JoinColumn(nullable = false) @Setter
    private Stock stock;
    @ManyToOne @JoinColumn(name = "venta_id",nullable = false) @Setter
    private Venta venta;

    public Double calcularSubtotal(){
        return cantidad * stock.getArticulo().getPrecio();
    }

}
