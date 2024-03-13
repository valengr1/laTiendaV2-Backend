package ingSoftware.laTienda.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConfirmarPagoRequest {
    private String site_transaction_id;
    private int payment_method_id;
    private String token;
    private String bin;
    private Double amount;
    private String currency;
    private int installments;
    private String payment_type;
    private String establishment_name;
    private List<Sub_payments> sub_payments;
}
