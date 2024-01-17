package ingSoftware.laTienda.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class CondicionTributaria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long id;
    @Column @Getter @Setter
    private String descripcion;
    @OneToOne(mappedBy = "condicionTributaria") @Getter @Setter
    private Cliente cliente;
    @OneToOne(mappedBy = "condicionTributaria") @Getter @Setter
    private Tienda tienda;
}
