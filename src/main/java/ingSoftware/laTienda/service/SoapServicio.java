package ingSoftware.laTienda.service;

import ingSoftware.laTienda.client.SoapClient;
import ingSoftware.laTienda.wsdl.Autorizacion;
import ingSoftware.laTienda.wsdl.ObjectFactory;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacionResponse;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoapServicio {
    private final SoapClient soapClient;

    @Autowired
    public SoapServicio(SoapClient soapClient){
        this.soapClient = soapClient;
    }
    public SolicitarAutorizacionResponse solicitarAutorizacion(String codigo){
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> codigoElement = objectFactory.createString(codigo);
        System.out.println(codigoElement.getValue());
        return soapClient.solicitarAutorizacion(codigoElement);
    }
}
