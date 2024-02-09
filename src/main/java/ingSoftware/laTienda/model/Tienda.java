package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class Tienda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CUIT;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @ManyToOne @JoinColumn(nullable = false)
    private CondicionTributaria condicionTributaria;
}
