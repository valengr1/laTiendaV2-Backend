package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Vendedor {
    @Id
    @Getter @Setter
    private Long legajo;
    @Column(nullable = false)
    @Getter @Setter
    private String contraseña;
    @Column(nullable = false)
    @Getter @Setter
    private String nombre;
    @Column(nullable = false)
    @Getter @Setter
    private String apellido;
    @ManyToOne @JoinColumn @Getter @Setter
    private Sucursal sucursal;
}
