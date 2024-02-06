package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @AllArgsConstructor @NoArgsConstructor @ToString
public class LineaVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) @Getter@Setter
    private int cantidad;
    @OneToOne @JoinColumn(nullable = false) @Getter@Setter
    private Stock stock;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Venta venta;

}
