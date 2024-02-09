package ingSoftware.laTienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.Getter;
import lombok.Setter;

public enum TipoComprobante {
    FACTURA_A("FacturaA"),
    FACTURA_B("FacturaB");

    public final String value;

    TipoComprobante(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoComprobante fromValue(String v) {
        for (TipoComprobante c: TipoComprobante.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
