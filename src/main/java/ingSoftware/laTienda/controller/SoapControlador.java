package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.client.SoapClient;
import ingSoftware.laTienda.service.SoapServicio;
import ingSoftware.laTienda.wsdl.Autorizacion;
import ingSoftware.laTienda.wsdl.ObjectFactory;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacionResponse;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapControlador {
    SoapServicio soapServicio;


    @Autowired
    public SoapControlador(SoapServicio soapServicio){
        this.soapServicio = soapServicio;
    }

    @PostMapping("/soap/solicitarAutorizacion")
    public SolicitarAutorizacionResponse solicitarAutorizacion(@RequestParam String codigo){
    return soapServicio.solicitarAutorizacion(codigo);
    }
}
