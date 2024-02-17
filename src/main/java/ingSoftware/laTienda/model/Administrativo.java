package ingSoftware.laTienda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Entity
public class Administrativo {
    @Id
    private Long legajo;
    @Column
    private String contraseña;
    @Column
    private String nombre;
    @Column
    private String apellido;
}
