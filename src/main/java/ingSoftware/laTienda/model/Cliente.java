package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class Cliente {
    @Id @Getter @Setter
    private Long DNI;
    @Column @Getter @Setter
    private String nombre;
    @Column @Getter @Setter
    private String apellido;
    @Column @Getter @Setter
    private String direccion;
    @Column @Getter @Setter
    private String telefono;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private CondicionTributaria condicionTributaria;
}
