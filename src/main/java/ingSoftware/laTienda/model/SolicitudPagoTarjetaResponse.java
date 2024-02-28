package ingSoftware.laTienda.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SolicitudPagoTarjetaResponse {
    private String id;
    private String status;
    private String card_number_length;
    private String date_created;
    private String bin;
    private String last_four_digits;
    private String security_code_length;
    private String expiration_month;
    private String expiration_year;
    private String date_due;
    private Cardholder cardholder;

}
