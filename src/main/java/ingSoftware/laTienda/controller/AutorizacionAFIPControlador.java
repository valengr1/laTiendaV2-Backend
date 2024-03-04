package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.service.AutorizacionAFIPServicio;
import ingSoftware.laTienda.service.ClienteServicio;
import ingSoftware.laTienda.wsdl.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@RestController
public class AutorizacionAFIPControlador {
    AutorizacionAFIPServicio autorizacionAFIPServicio;
    ClienteServicio clienteServicio;

    @Autowired
    public AutorizacionAFIPControlador(AutorizacionAFIPServicio autorizacionAFIPServicio, ClienteServicio clienteServicio){
        this.autorizacionAFIPServicio = autorizacionAFIPServicio;
        this.clienteServicio = clienteServicio;
    }

    public AutorizacionAFIPControlador(){

    }

//    @GetMapping("api/autorizacionAFIP/solicitarToken")
//    public SolicitarAutorizacionResponse solicitarToken(){
//        return autorizacionAFIPServicio.solicitarAutorizacion("222D6106-B8FA-4F08-B0E6-A2E89AE02247");
//    }
//
//    @GetMapping("/api/autorizacionAFIP/solicitarUltimosComprobantes")
//    public SolicitarUltimosComprobantesResponse solicitarUltimosComprobantes(){
//        String token = solicitarToken().getSolicitarAutorizacionResult().getValue().getToken().getValue();
//        return autorizacionAFIPServicio.solicitarUltimosComprobantes(token);
//    }
//
//    public SolicitarCaeResponse solicitarCae(SolicitudAutorizacion solicitudAutorizacion){
//        String token = solicitarToken().getSolicitarAutorizacionResult().getValue().getToken().getValue();
//        return autorizacionAFIPServicio.solicitarCae(token, solicitudAutorizacion);
//    }

//    @GetMapping("/api/autorizacionAFIP/solicitarCae")
//    public SolicitarCaeResponse solicitarCae(@RequestParam String tipoComprobante, @RequestParam String tipoDocumento, @RequestParam Long numeroDocumento, @RequestParam double importeTotal) throws Exception {
//        String token = solicitarToken().getSolicitarAutorizacionResult().getValue().getToken().getValue();
//
//        TipoDocumento tipoDocumentoSolicitud = switch (tipoDocumento) {
//            case "DNI" -> TipoDocumento.DNI;
//            case "CUIT" -> TipoDocumento.CUIT;
//            case "CUIL" -> TipoDocumento.CUIL;
//            case "CONSUMIDOR FINAL" -> TipoDocumento.CONSUMIDOR_FINAL;
//            default -> throw new IllegalStateException("Unexpected value: " + tipoDocumento);
//        };
//
//        Long numeroDocumentoSolicitud = getNumeroDocumentoSolicitud(tipoDocumento, numeroDocumento);
//
//        TipoComprobante tipoComprobanteSolicitud = switch (tipoComprobante){
//            case "FACTURA_A" -> TipoComprobante.FACTURA_A;
//            case "FACTURA_B" -> TipoComprobante.FACTURA_B;
//            default -> throw new IllegalStateException("Unexpected value: " + tipoComprobante);
//        };
//
//        double importeIvaRedondeado = redondearDecimales(importeTotal * 0.21, 2);
//        double importeNetoRedondeado = redondearDecimales(importeTotal - importeIvaRedondeado, 2);
//        double importeTotalRedondeado = redondearDecimales(importeTotal, 2);
//
//        GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
//        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);
//
//        ObjectFactory factory = new ObjectFactory();
//        JAXBElement<XMLGregorianCalendar> fechaJaxb = factory.createSolicitudAutorizacionFecha(fecha);
//
//        SolicitudAutorizacion solicitudAutorizacion = getSolicitudAutorizacion(tipoComprobanteSolicitud, tipoDocumentoSolicitud, numeroDocumentoSolicitud, importeTotalRedondeado, importeNetoRedondeado, importeIvaRedondeado, fechaJaxb);
//        return autorizacionAFIPServicio.solicitarCae(token, solicitudAutorizacion);
//    }

//    private static Long getNumeroDocumentoSolicitud(String tipoDocumento, Long numeroDocumento) {
//        Long numeroDocumentoSolicitud;
//        boolean numeroDocumentoComprobacion = switch (tipoDocumento){
//            case "DNI" -> numeroDocumento.toString().length() == 7 || numeroDocumento.toString().length() == 8;
//            case "CUIT", "CUIL" -> numeroDocumento.toString().length() == 11;
//            case "CONSUMIDOR FINAL" -> numeroDocumento == 0;
//            default -> throw new IllegalStateException("Unexpected value: " + numeroDocumento);
//        };
//        if(numeroDocumentoComprobacion){
//            numeroDocumentoSolicitud = numeroDocumento;
//        } else{
//            throw new IllegalArgumentException("Unexpected value: " + numeroDocumento);
//        }
//        return numeroDocumentoSolicitud;
//    }
//
//    private static SolicitudAutorizacion getSolicitudAutorizacion(TipoComprobante tipoComprobante, TipoDocumento tipoDocumento,Long numeroDocumento,double importeTotal, double importeNeto, double importeIva, JAXBElement<XMLGregorianCalendar> fechaJaxb)  {
//        SolicitudAutorizacion solicitudAutorizacion = new SolicitudAutorizacion();
//        solicitudAutorizacion.setImporteTotal(importeTotal);
//        solicitudAutorizacion.setImporteIva(importeIva);
//        solicitudAutorizacion.setImporteNeto(importeNeto);
//        solicitudAutorizacion.setNumeroDocumento(numeroDocumento);
//        solicitudAutorizacion.setTipoComprobante(tipoComprobante);
//        solicitudAutorizacion.setTipoDocumento(tipoDocumento);
//        solicitudAutorizacion.setFecha(fechaJaxb);
//        solicitudAutorizacion.setNumero(1L);
//        return solicitudAutorizacion;
//    }
//
//    public double redondearDecimales(double valorInicial, int numeroDecimales) {
//        double parteEntera, resultado;
//        resultado = valorInicial;
//        parteEntera = Math.floor(resultado);
//        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
//        resultado=Math.round(resultado);
//        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
//        return resultado;
//    }
}
