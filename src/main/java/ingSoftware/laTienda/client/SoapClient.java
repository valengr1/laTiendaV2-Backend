package ingSoftware.laTienda.client;

import ingSoftware.laTienda.wsdl.ObjectFactory;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacion;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacionResponse;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
    public SolicitarAutorizacionResponse solicitarAutorizacion(JAXBElement<String> codigo){
        SolicitarAutorizacion solicitarAutorizacion = new SolicitarAutorizacion();
        solicitarAutorizacion.setCodigo(codigo);
        SoapActionCallback actionCallback = new SoapActionCallback("http://ISTP1.Service.Contracts.Service/SolicitarAutorizacion");
        return (SolicitarAutorizacionResponse) getWebServiceTemplate().marshalSendAndReceive("http://istp1service.azurewebsites.net/LoginService.svc", solicitarAutorizacion, actionCallback);

    }
}
