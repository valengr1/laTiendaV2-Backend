package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class PuntoVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(nullable = false)
    private Sucursal sucursal;
}
