package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.client.SoapClient;
import ingSoftware.laTienda.model.Cliente;
import ingSoftware.laTienda.service.ClienteServicio;
import ingSoftware.laTienda.wsdl.*;
import jakarta.xml.bind.JAXBElement;
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
    public SolicitarCaeResponse solicitarCae(@RequestParam Double importeTotal, @RequestParam Long numeroDocumentoCliente) throws DatatypeConfigurationException, ParseException {
        //obtener token
        SolicitarAutorizacionResponse solicitarAutorizacionResponse = soapClient.solicitarAutorizacion(System.getenv("codigoGrupoIS"));
        String token = solicitarAutorizacionResponse.getSolicitarAutorizacionResult().getValue().getToken().getValue();
        //construir solicitud de autorizacion
        String tipoComprobanteDeterminado = determinarTipoComprobante(numeroDocumentoCliente);
        TipoComprobante tipoComprobante = TipoComprobante.fromValue(tipoComprobanteDeterminado);
        Integer tipoComprobanteId = determinarTipoComprobanteId(numeroDocumentoCliente);
        TipoDocumento tipoDocumentoCliente = determinarTipoDocumentoCliente(numeroDocumentoCliente.toString());
        GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<XMLGregorianCalendar> fechaJaxb = factory.createSolicitudAutorizacionFecha(fecha);
        SolicitarUltimosComprobantesResponse solicitarUltimosComprobantesResponse = solicitarUltimosComprobantes();
        ArrayOfComprobante comprobantes = solicitarUltimosComprobantesResponse.getSolicitarUltimosComprobantesResult().getValue().getComprobantes().getValue();
        long numero = 1L;
//        for(Comprobante comprobante : comprobantes.getComprobante()){
//            if(comprobante.getId().equals(tipoComprobanteId)){
//                 numero = comprobante.getNumero();
//            }
//        }
        double importeIva = importeTotal * 0.21;
        double importeNeto = importeTotal - importeIva;
        SolicitudAutorizacion solicitudAutorizacion = new SolicitudAutorizacion();
        solicitudAutorizacion.setImporteTotal(formatearDecimales(importeTotal, 2));
        solicitudAutorizacion.setImporteIva(formatearDecimales(importeIva, 2));
        solicitudAutorizacion.setImporteNeto(formatearDecimales(importeNeto, 2));
        solicitudAutorizacion.setNumeroDocumento(numeroDocumentoCliente);
        solicitudAutorizacion.setTipoComprobante(tipoComprobante);
        solicitudAutorizacion.setTipoDocumento(tipoDocumentoCliente);
        solicitudAutorizacion.setFecha(fechaJaxb);
        solicitudAutorizacion.setNumero(numero);
        //solicitar CAE
        return soapClient.solicitarCae(token, solicitudAutorizacion);
    }


    private String determinarTipoComprobante(Long numeroDocumentoCliente) {
        Cliente cliente = clienteServicio.obtenerClienteByDNI(numeroDocumentoCliente);
        if(cliente.getCondicionTributaria().getDescripcion().equals("Responsable Inscripto") || cliente.getCondicionTributaria().getDescripcion().equals("Monotributo")){
            return "FacturaA"; //tipo de factura A
        } else {
            return "FacturaB"; // tipo de factura B
        }
    }

    public Double formatearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

    private Integer determinarTipoComprobanteId(Long numeroDocumentoCliente) {
        Cliente cliente = clienteServicio.obtenerClienteByDNI(numeroDocumentoCliente);
        if(cliente.getCondicionTributaria().getDescripcion().equals("Responsable Inscripto") || cliente.getCondicionTributaria().getDescripcion().equals("Monotributo")){
            return 1; //tipo de factura A
        } else {
            return 6; // tipo de factura B
        }
    }

    private TipoDocumento determinarTipoDocumentoCliente(String numeroDocumentoCliente) {
         if(numeroDocumentoCliente.length() == 7 || numeroDocumentoCliente.length() == 8){
            return TipoDocumento.DNI;
        } else if(numeroDocumentoCliente.length() == 11){
            return TipoDocumento.CUIT;
        } else {
            return TipoDocumento.CONSUMIDOR_FINAL;
         }
    }
}
