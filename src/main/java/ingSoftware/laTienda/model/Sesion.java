package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.GregorianCalendar;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Sesion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @ManyToOne @JoinColumn
    private Vendedor vendedor;
}
