package ingSoftware.laTienda.DTOs;

import lombok.*;

@ToString @AllArgsConstructor @NoArgsConstructor
public class StockDTO {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String talle;
    @Getter @Setter
    private String color;
    @Getter @Setter
    private String descripcionArticulo;
    @Getter @Setter
    private String marca;
    @Getter @Setter
    private Integer cantidadDisponible;
    @Getter @Setter
    private Double precioVenta;
}
