package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.service.AutorizacionPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController @CrossOrigin("http://localhost:5173")
public class AutorizacionPagoControlador {
    AutorizacionPagoServicio autorizacionPagoServicio;
    @Autowired
    public AutorizacionPagoControlador(AutorizacionPagoServicio autorizacionPagoServicio){
        this.autorizacionPagoServicio = autorizacionPagoServicio;
    }

    @GetMapping("/api/autorizacionPago/solicitarToken")
    public String solicitarToken() throws URISyntaxException, IOException, InterruptedException {
        return autorizacionPagoServicio.solicitarTokenPago();
    }
}
