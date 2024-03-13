package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Vendedor {
    @Id
    private Long legajo;
    @Column(nullable = false)
    private String contraseña;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @ManyToOne @JoinColumn
    private PuntoVenta puntoVenta;
}
