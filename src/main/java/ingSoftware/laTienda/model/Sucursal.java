package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Sucursal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @ManyToOne @JoinColumn(nullable = false)
    private Tienda tienda;
}
