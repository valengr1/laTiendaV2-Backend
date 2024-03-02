package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "stock")
    private List<LineaVenta> lineaVenta;
    @Column(nullable = false)
    private Integer cantidad;
}
