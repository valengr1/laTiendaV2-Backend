package ingSoftware.laTienda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;

//    @Column
//    private String descripcion;
//
//    @Column
//    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private TipoComprobante tipoComprobante;

//    @OneToMany(mappedBy = "comprobante")
//    private List<CondicionTributaria> condicionesTributariasCliente;
//
//    @OneToMany(mappedBy = "comprobante")
//    private List<CondicionTributaria> condicionesTributariasVendedor;

    @OneToOne
    @JoinColumn(name = "venta_id", updatable = false)
    @Setter
    private Venta venta;

    public void asignarTipoComprobante(CondicionTributaria condicionTributariaCliente, CondicionTributaria condicionTributariaTienda){
        String descripcionCtCliente = condicionTributariaCliente.getDescripcion();
        String descripcionCtVendedor = condicionTributariaTienda.getDescripcion();
        if(!descripcionCtVendedor.isBlank() && descripcionCtVendedor.equals("Responsable Inscripto")){
            if(!descripcionCtCliente.isBlank() && descripcionCtCliente.equals("Responsable Inscripto") || descripcionCtCliente.equals("Monotributo")){
                this.setTipoComprobante(TipoComprobante.FACTURA_A);
            }else if(!descripcionCtCliente.isBlank() && descripcionCtCliente.equals("Consumidor Final") || descripcionCtCliente.equals("Exento") || descripcionCtCliente.equals("No Responsable")){
                this.setTipoComprobante(TipoComprobante.FACTURA_B);
            } else{
                throw new IllegalArgumentException("La condición tributaria del cliente no es válida");
            }
        }
        throw new IllegalArgumentException("La condición tributaria del vendedor no es válida");
    }
}
