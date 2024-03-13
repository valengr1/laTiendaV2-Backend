package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Comprobante;
import ingSoftware.laTienda.service.ComprobanteServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController @CrossOrigin("http://localhost:5173")
public class ComprobanteControlador {
    ComprobanteServicio comprobanteServicio;

    public ComprobanteControlador(ComprobanteServicio comprobanteServicio){
        this.comprobanteServicio = comprobanteServicio;
    }

    @GetMapping("/api/comprobantes")
    public List<Comprobante> listarComprobantes(){
        return comprobanteServicio.listarComprobantes();
    }

    @GetMapping("/api/comprobantes/{idCondicionTributariaCliente}")
    public String determinarTipoComprobanteAEmitir(@PathVariable Long idCondicionTributariaCliente){
        return comprobanteServicio.determinarTipoComprobanteAEmitir(idCondicionTributariaCliente);
    }

    @GetMapping("/api/comprobantes/ultimo")
    public Integer obtenerUltimoNumeroComprobante(){
        return comprobanteServicio.obtenerUltimoNumeroComprobante();
    }
}
