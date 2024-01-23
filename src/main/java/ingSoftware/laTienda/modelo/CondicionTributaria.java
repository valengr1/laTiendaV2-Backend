package ingSoftware.laTienda.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class CondicionTributaria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    @Column @Getter @Setter
    private String descripcion;

}
