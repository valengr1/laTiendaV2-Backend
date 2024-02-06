package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Sucursal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    @Column @Getter @Setter
    private String nombre;
    @Column @Getter @Setter
    private String direccion;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Tienda tienda;
}
