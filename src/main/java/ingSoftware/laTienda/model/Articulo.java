package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Articulo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Double costo;
    @Column(nullable = false)
    private Double margenGanancia;
    @ManyToOne @JoinColumn(nullable = false)
    private Marca marca;
    @ManyToOne @JoinColumn(nullable = false)
    private Categoria categoria;
    @ManyToOne @JoinColumn
    private TipoTalle tipoTalle;
    public Double getPrecio() {
        double netoGravado = costo + costo * margenGanancia;
        double IVA = netoGravado * 0.21;
        return netoGravado + IVA;
    }
}
