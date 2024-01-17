package ingSoftware.laTienda.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column @Getter @Setter
    private String fecha;
    @Column @Getter @Setter
    private String hora;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private PuntoVenta puntoVenta;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Vendedor vendedor;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Cliente cliente;
    @OneToOne @JoinColumn(nullable = false) @Getter @Setter
    private Pago pago;
}
