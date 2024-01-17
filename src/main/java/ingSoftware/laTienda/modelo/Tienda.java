package ingSoftware.laTienda.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class Tienda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long CUIT;
    @Column @Getter @Setter
    private String nombre;
    @Column @Getter @Setter
    private String direccion;
    @Column @Getter @Setter
    private String telefono;
    @OneToOne @JoinColumn(nullable = false) @Getter @Setter
    private CondicionTributaria condicionTributaria;
}
