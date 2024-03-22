package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class CondicionTributaria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descripcion;
//    @ManyToOne @JoinColumn(nullable = false)
//    private Comprobante comprobante;
}
