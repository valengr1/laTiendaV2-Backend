package ingSoftware.laTienda.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Talle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    @Column(nullable = false) @Getter @Setter
    private String descripcion;
    @ManyToOne @JoinColumn @Getter @Setter
    private TipoTalle tipoTalle;

}
