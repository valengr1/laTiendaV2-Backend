package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Tarjeta;
import ingSoftware.laTienda.service.AutorizacionPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController @CrossOrigin("http://localhost:5173")
public class AutorizacionPagoControlador {
    AutorizacionPagoServicio autorizacionPagoServicio;
    @Autowired
    public AutorizacionPagoControlador(AutorizacionPagoServicio autorizacionPagoServicio){
        this.autorizacionPagoServicio = autorizacionPagoServicio;
    }

    @PostMapping("/api/autorizacionesPagoTarjeta/{monto}")
    public String solicitarToken(@RequestBody Tarjeta tarjeta, @PathVariable Double monto) throws URISyntaxException, IOException, InterruptedException {
            return autorizacionPagoServicio.solicitarTokenPago(tarjeta, monto);
    }
}
