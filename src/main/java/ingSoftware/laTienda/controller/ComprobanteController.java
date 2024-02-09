package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Comprobante;
import ingSoftware.laTienda.model.TipoComprobante;
import ingSoftware.laTienda.service.ComprobanteServicio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController @CrossOrigin("http://localhost:5173")
public class ComprobanteController {
    ComprobanteServicio comprobanteServicio;

    public ComprobanteController(ComprobanteServicio comprobanteServicio){
        this.comprobanteServicio = comprobanteServicio;
    }

    @GetMapping("/listarComprobantes")
    public List<Comprobante> listarComprobantes(){
        return comprobanteServicio.listarComprobantes();
    }

    @GetMapping("/determinarTipoComprobanteAEmitir")
    public String determinarTipoComprobanteAEmitir(@RequestParam Long idCondicionTributariaCliente){
        return comprobanteServicio.determinarTipoComprobanteAEmitir(idCondicionTributariaCliente);
    }
}
