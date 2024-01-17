package ingSoftware.laTienda.DTOs;

import lombok.*;

@AllArgsConstructor @ToString @NoArgsConstructor
public class ArticuloDTO {
    @Getter @Setter
    private Long codigo;
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
    private String marca;
    @Getter @Setter
    private String categoria;
    @Getter @Setter
    private Double precio;
    @Getter @Setter
    private String tipoTalle;
}
