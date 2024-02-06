//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.02.05 a las 08:40:28 PM ART 
//


package ingSoftware.laTienda.wsdl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EstadoSolicitud.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>
 * &lt;simpleType name="EstadoSolicitud"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Aprobada"/&gt;
 *     &lt;enumeration value="Rechazada"/&gt;
 *     &lt;enumeration value="AprobadaParcialmente"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EstadoSolicitud", namespace = "http://schemas.datacontract.org/2004/07/SGE.Fwk.Domain.Core")
@XmlEnum
public enum EstadoSolicitud {

    @XmlEnumValue("Aprobada")
    APROBADA("Aprobada"),
    @XmlEnumValue("Rechazada")
    RECHAZADA("Rechazada"),
    @XmlEnumValue("AprobadaParcialmente")
    APROBADA_PARCIALMENTE("AprobadaParcialmente");
    private final String value;

    EstadoSolicitud(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoSolicitud fromValue(String v) {
        for (EstadoSolicitud c: EstadoSolicitud.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
