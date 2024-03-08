package ingSoftware.laTienda.service;

import ingSoftware.laTienda.wsdl.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AutorizacionAFIPServicio extends WebServiceGatewaySupport {
    public SolicitarAutorizacionResponse solicitarAutorizacion(String codigo){
        SolicitarAutorizacion autorizacionRequest = new SolicitarAutorizacion();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> codigoJaxb = factory.createSolicitarAutorizacionCodigo(codigo);
        autorizacionRequest.setCodigo(codigoJaxb);
        SoapActionCallback actionCallback = new SoapActionCallback("http://ISTP1.Service.Contracts.Service/ILoginService/SolicitarAutorizacion");
        return (SolicitarAutorizacionResponse) getWebServiceTemplate().marshalSendAndReceive("http://istp1service.azurewebsites.net/LoginService.svc", autorizacionRequest, actionCallback);
    }

    public SolicitarUltimosComprobantesResponse solicitarUltimosComprobantes(String token){
        SolicitarUltimosComprobantes solicitarUltimosComprobantes = new SolicitarUltimosComprobantes();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> tokenJaxb = factory.createSolicitarUltimosComprobantesToken(token);
        solicitarUltimosComprobantes.setToken(tokenJaxb);
        SoapActionCallback actionCallback = new SoapActionCallback("http://ISTP1.Service.Contracts.Service/ILoginService/SolicitarUltimosComprobantes");
        return (SolicitarUltimosComprobantesResponse) getWebServiceTemplate().marshalSendAndReceive("http://istp1service.azurewebsites.net/LoginService.svc", solicitarUltimosComprobantes, actionCallback);
    }

    public SolicitarCaeResponse solicitarCae() throws DatatypeConfigurationException {

        String token = "222D6106-B8FA-4F08-B0E6-A2E89AE02247PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgc3JjPSJDTj13c2FhaG9tbywgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiIHVuaXF1ZV9pZD0iNDQ2MDA3MTY4IiBnZW5fdGltZT0iMTcwOTczMTY4MiIgZXhwX3RpbWU9IjE3MDk3NzQ5NDIiLz4KICAgIDxvcGVyYXRpb24gdHlwZT0ibG9naW4iIHZhbHVlPSJncmFudGVkIj4KICAgICAgICA8bG9naW4gZW50aXR5PSIzMzY5MzQ1MDIzOSIgc2VydmljZT0id3NmZSIgdWlkPSJTRVJJQUxOVU1CRVI9Q1VJVCAyMDI1OTkyNzE2MiwgQ049c2dlZmp2MDUiIGF1dGhtZXRob2Q9ImNtcyIgcmVnbWV0aG9kPSIyMiI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24ga2V5PSIyMDI1OTkyNzE2MiIgcmVsdHlwZT0iNCIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgo=";
        SolicitudAutorizacion solicitud = new SolicitudAutorizacion();

        GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
        XMLGregorianCalendar fechaSolicitud = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<XMLGregorianCalendar> fechaJaxb = factory.createSolicitudAutorizacionFecha(fechaSolicitud);
        double importeTotal = 100000.00;
        double importeIva = 21000.00;
        double importeNeto = 79000.00;

        solicitud.setImporteTotal(importeTotal);
        solicitud.setImporteIva(importeIva);
        solicitud.setImporteNeto(importeNeto);
        solicitud.setNumero(1L);
        solicitud.setTipoComprobante(TipoComprobante.FACTURA_B); // value = "FacturaB", ordinal = 1
        solicitud.setTipoDocumento(TipoDocumento.DNI); // value = "Dni" , ordinal = 2
        solicitud.setNumeroDocumento(43501537L);
        solicitud.setFecha(fechaJaxb);

        SolicitarCae solicitarCae = new SolicitarCae();
        JAXBElement<String> tokenJaxb = factory.createSolicitarCaeToken(token);
        solicitarCae.setToken(tokenJaxb);

        JAXBElement<SolicitudAutorizacion> solicitudAutorizacionJaxb = factory.createSolicitudAutorizacion(solicitud);
        solicitarCae.setSolicitud(solicitudAutorizacionJaxb);

        SoapActionCallback actionCallback = new SoapActionCallback("http://ISTP1.Service.Contracts.Service/ILoginService/SolicitarCae");
        SolicitarCaeResponse solicitar = (SolicitarCaeResponse) getWebServiceTemplate().marshalSendAndReceive("http://istp1service.azurewebsites.net/LoginService.svc", solicitarCae, actionCallback);
        return solicitar;
    }
}
