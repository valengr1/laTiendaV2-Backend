package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Pago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) @Getter @Setter
    private Double monto;
    @OneToOne(mappedBy = "pago") @Getter @Setter
    private Venta venta;
}
