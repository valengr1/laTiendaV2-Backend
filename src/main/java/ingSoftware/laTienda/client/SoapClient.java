package ingSoftware.laTienda.client;

import ingSoftware.laTienda.wsdl.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
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

    public SolicitarCaeResponse solicitarCae(String token, SolicitudAutorizacion solicitud){
        SolicitarCae solicitarCae = new SolicitarCae();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> tokenJaxb = factory.createSolicitarCaeToken(token);
        solicitarCae.setToken(tokenJaxb);
        JAXBElement<SolicitudAutorizacion> solicitudAutorizacionJaxb = factory.createSolicitudAutorizacion(solicitud);
        solicitarCae.setSolicitud(solicitudAutorizacionJaxb);
        SoapActionCallback actionCallback = new SoapActionCallback("http://ISTP1.Service.Contracts.Service/ILoginService/SolicitarCae");
        return (SolicitarCaeResponse) getWebServiceTemplate().marshalSendAndReceive("http://istp1service.azurewebsites.net/LoginService.svc", solicitarCae, actionCallback);
    }
}
