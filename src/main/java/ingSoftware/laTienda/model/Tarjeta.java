package ingSoftware.laTienda.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tarjeta {
    String numeroTarjeta;
    String mesVencimiento;
    String anioVencimiento;
    String codigoSeguridad;
    String nombreTitular;
    String dniTitular;
}
