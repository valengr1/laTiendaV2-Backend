package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Setter
@Getter
@Entity @NoArgsConstructor @AllArgsConstructor @ToString
@SQLDelete(sql = "UPDATE Articulo SET deleted = true WHERE codigo = ?")
//@SQLRestriction("deleted = false")
public class Articulo {
    @Id
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
    @Column
    private Boolean deleted;
    public Double getPrecio() {
        double netoGravado = costo + costo * margenGanancia;
        double IVA = netoGravado * 0.21;
        return netoGravado + IVA;
    }
}
