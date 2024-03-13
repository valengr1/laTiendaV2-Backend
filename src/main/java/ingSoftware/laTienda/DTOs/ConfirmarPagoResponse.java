package ingSoftware.laTienda.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class ConfirmarPagoResponse {
    private String card_brand;
    private Double amount;
    private String status;
    private String currency;
    private String error_type;
}
