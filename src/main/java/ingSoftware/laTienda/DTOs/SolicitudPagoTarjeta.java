package ingSoftware.laTienda.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudPagoTarjeta {
    private String card_number;
    private String card_expiration_month;
    private String card_expiration_year;
    private String security_code;
    private String card_holder_name;
    private Card_holder_identification card_holder_identification;

}
