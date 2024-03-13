package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Comprobante;
import ingSoftware.laTienda.model.TipoComprobante;
import ingSoftware.laTienda.repository.ComprobanteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprobanteServicio {
    ComprobanteRepositorio comprobanteRepositorio;

    @Autowired
    public ComprobanteServicio(ComprobanteRepositorio comprobanteRepositorio){
        this.comprobanteRepositorio = comprobanteRepositorio;
    }

    public List<Comprobante> listarComprobantes(){
        return comprobanteRepositorio.findAll();
    }
    public Integer obtenerUltimoNumeroComprobante(){
        return comprobanteRepositorio.obtenerUltimoNumeroComprobante();
    }
    public String determinarTipoComprobanteAEmitir(Long idCondicionTributariaCliente) {
        if(idCondicionTributariaCliente >= 1 && idCondicionTributariaCliente <= 5){
            if(idCondicionTributariaCliente == 1 || idCondicionTributariaCliente == 2){
                return "Factura A";
            } else {
                return "Factura B";
            }
        } else {
            throw new IllegalArgumentException(String.valueOf(idCondicionTributariaCliente));
        }
    }
}
