package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class Cliente {
    @Id
    private Long DNI;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @ManyToOne @JoinColumn(nullable = false)
    private CondicionTributaria condicionTributaria;
}
