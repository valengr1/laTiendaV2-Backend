package ingSoftware.laTienda.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import ingSoftware.laTienda.wsdl.TipoComprobante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
public class Comprobante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;
    @Column
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private TipoComprobante tipoComprobante;
}
