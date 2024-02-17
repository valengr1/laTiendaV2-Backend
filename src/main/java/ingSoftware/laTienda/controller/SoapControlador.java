package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.client.SoapClient;
import ingSoftware.laTienda.model.Cliente;
import ingSoftware.laTienda.service.ClienteServicio;
import ingSoftware.laTienda.wsdl.*;
import jakarta.xml.bind.JAXBElement;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@RestController
public class SoapControlador {
    SoapClient soapClient;
    ClienteServicio clienteServicio;

    @Autowired
    public SoapControlador(SoapClient soapClient, ClienteServicio clienteServicio){
        this.soapClient = soapClient;
        this.clienteServicio = clienteServicio;
    }

    @GetMapping("/solicitarUltimosComprobantes")
    public SolicitarUltimosComprobantesResponse solicitarUltimosComprobantes(){
        SolicitarAutorizacionResponse solicitarAutorizacionResponse = soapClient.solicitarAutorizacion(System.getenv("codigoGrupoIS"));
        String token = solicitarAutorizacionResponse.getSolicitarAutorizacionResult().getValue().getToken().getValue();
        return soapClient.solicitarUltimosComprobantes(token);
    }

    @GetMapping("/solicitarCae")
    public SolicitarCaeResponse solicitarCae(@RequestParam String tipoComprobante, @RequestParam String tipoDocumento, @RequestParam Long numeroDocumento, @RequestParam double importeTotal) throws Exception {
        SolicitarAutorizacionResponse solicitarAutorizacionResponse = soapClient.solicitarAutorizacion(System.getenv("codigoGrupoIS"));
        String token = solicitarAutorizacionResponse.getSolicitarAutorizacionResult().getValue().getToken().getValue();

        TipoDocumento tipoDocumentoSolicitud = switch (tipoDocumento) {
            case "DNI" -> TipoDocumento.DNI;
            case "CUIT" -> TipoDocumento.CUIT;
            case "CUIL" -> TipoDocumento.CUIL;
            case "CONSUMIDOR FINAL" -> TipoDocumento.CONSUMIDOR_FINAL;
            default -> throw new IllegalStateException("Unexpected value: " + tipoDocumento);
        };

        Long numeroDocumentoSolicitud = getNumeroDocumentoSolicitud(tipoDocumento, numeroDocumento);

        TipoComprobante tipoComprobanteSolicitud = switch (tipoComprobante){
            case "FACTURA_A" -> TipoComprobante.FACTURA_A;
            case "FACTURA_B" -> TipoComprobante.FACTURA_B;
            default -> throw new IllegalStateException("Unexpected value: " + tipoComprobante);
        };

        double importeIvaRedondeado = redondearDecimales(importeTotal * 0.21, 2);
        double importeNetoRedondeado = redondearDecimales(importeTotal - importeIvaRedondeado, 2);
        double importeTotalRedondeado = redondearDecimales(importeTotal, 2);

        GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);

        ObjectFactory factory = new ObjectFactory();
        JAXBElement<XMLGregorianCalendar> fechaJaxb = factory.createSolicitudAutorizacionFecha(fecha);

        SolicitudAutorizacion solicitudAutorizacion = getSolicitudAutorizacion(tipoComprobanteSolicitud, tipoDocumentoSolicitud, numeroDocumentoSolicitud, importeTotalRedondeado, importeNetoRedondeado, importeIvaRedondeado, fechaJaxb);
        return soapClient.solicitarCae(token, solicitudAutorizacion);
    }
    private static Long getNumeroDocumentoSolicitud(String tipoDocumento, Long numeroDocumento) {
        Long numeroDocumentoSolicitud = null;
        boolean numeroDocumentoComprobacion = switch (tipoDocumento){
            case "DNI" -> numeroDocumento.toString().length() == 7 || numeroDocumento.toString().length() == 8;
            case "CUIT", "CUIL" -> numeroDocumento.toString().length() == 11;
            case "CONSUMIDOR FINAL" -> numeroDocumento == 0;
            default -> throw new IllegalStateException("Unexpected value: " + numeroDocumento);
        };
        if(numeroDocumentoComprobacion){
            numeroDocumentoSolicitud = numeroDocumento;
        } else{
            throw new IllegalArgumentException("Unexpected value: " + numeroDocumento);
        }
        return numeroDocumentoSolicitud;
    }

    private static SolicitudAutorizacion getSolicitudAutorizacion(TipoComprobante tipoComprobante, TipoDocumento tipoDocumento,Long numeroDocumento,double importeTotal, double importeNeto, double importeIva, JAXBElement<XMLGregorianCalendar> fechaJaxb) throws Exception {
        SolicitudAutorizacion solicitudAutorizacion = new SolicitudAutorizacion();
        solicitudAutorizacion.setImporteTotal(importeTotal);
        solicitudAutorizacion.setImporteIva(importeIva);
        solicitudAutorizacion.setImporteNeto(importeNeto);
        solicitudAutorizacion.setNumeroDocumento(numeroDocumento);
        solicitudAutorizacion.setTipoComprobante(tipoComprobante);
        solicitudAutorizacion.setTipoDocumento(tipoDocumento);
        solicitudAutorizacion.setFecha(fechaJaxb);
        solicitudAutorizacion.setNumero(2L);
        return solicitudAutorizacion;
    }

    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
}
