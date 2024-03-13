package ingSoftware.laTienda.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudPagoTarjetaResponse {
    private String id;
    private String status;
    private String bin;
}
