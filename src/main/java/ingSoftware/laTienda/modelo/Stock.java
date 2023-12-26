package ingSoftware.laTienda.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Column(nullable = false) @Getter @Setter
    private Integer cantidad;
}
