package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.client.SoapClient;
import ingSoftware.laTienda.wsdl.SolicitarAutorizacionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapControlador {
    SoapClient soapClient;

    @Autowired
    public SoapControlador(SoapClient soapClient){
        this.soapClient = soapClient;
    }
    @PostMapping("/solicitarAutorizacion")
    public SolicitarAutorizacionResponse solicitarAutorizacion(@RequestParam String codigoGrupo){
        return soapClient.solicitarAutorizacion(codigoGrupo);
    }
}
