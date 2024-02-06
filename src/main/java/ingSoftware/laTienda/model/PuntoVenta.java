package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class PuntoVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Sucursal sucursal;
}
