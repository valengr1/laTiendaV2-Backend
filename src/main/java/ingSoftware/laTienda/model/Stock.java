package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Stock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(nullable = false)
    private Articulo articulo;
    @ManyToOne @JoinColumn(nullable = false)
    private Color color;
    @ManyToOne @JoinColumn(nullable = false)
    private Talle talle;
    @ManyToOne @JoinColumn
    private Sucursal sucursal;
    @OneToOne(mappedBy = "stock")
    private LineaVenta lineaVenta;
    @Column(nullable = false)
    private Integer cantidad;

}
