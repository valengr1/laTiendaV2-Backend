package ingSoftware.laTienda.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sub_payments {
    private String site_id;
    private Double amount;
    private int installments;
}
