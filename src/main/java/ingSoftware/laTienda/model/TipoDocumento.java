package ingSoftware.laTienda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TipoDocumento {
    DNI("DNI"),
    CUIT("CUIT"),
    CUIL("CUIL");

    public final String value;

    TipoDocumento(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}
