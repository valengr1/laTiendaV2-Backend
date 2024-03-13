package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;

    @Column
    private String descripcion;

    @Column
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private TipoComprobante tipoComprobante;

    @OneToOne
    @JoinColumn(name = "venta_id", updatable = false)
    @Setter
    private Venta venta;
}
