package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Articulo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
    private Long codigo;
    @Column(nullable = false) @Getter @Setter
    private String descripcion;
    @Column(nullable = false) @Getter @Setter
    private Double costo;
    @Column(nullable = false) @Getter @Setter
    private Double margenGanancia;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Marca marca;
    @ManyToOne @JoinColumn(nullable = false) @Getter @Setter
    private Categoria categoria;
    @ManyToOne @JoinColumn @Getter @Setter
    private TipoTalle tipoTalle;
    public Double getPrecio() {
        double netoGravado = costo + costo * margenGanancia;
        double IVA = netoGravado * 0.21;
        return netoGravado + IVA;
    }
}
