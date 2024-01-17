package ingSoftware.laTienda.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class TipoTalle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    @Column @Getter @Setter
    private String descripcion;
}
