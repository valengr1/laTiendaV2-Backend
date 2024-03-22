package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Pago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) @Getter @Setter
    private Double monto;
    @OneToOne
    @JoinColumn(name = "venta_id" ,updatable = false, nullable = false) @Setter
    private Venta venta;
}
