package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Stock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Articulo articulo;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Color color;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Talle talle;
    @ManyToOne @JoinColumn @Getter @Setter
    private Sucursal sucursal;
    @OneToOne(mappedBy = "stock") @Getter @Setter
    private LineaVenta lineaVenta;
    @Column(nullable = false) @Getter @Setter
    private Integer cantidad;

}
