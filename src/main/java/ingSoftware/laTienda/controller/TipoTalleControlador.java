package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.TipoTalle;
import ingSoftware.laTienda.service.TipoTalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class TipoTalleControlador {
    TipoTalleServicio tipoTalleServicio;
    @Autowired
    public TipoTalleControlador(TipoTalleServicio tipoTalleServicio){
        this.tipoTalleServicio = tipoTalleServicio;
    }
    @GetMapping("/api/tiposTalle")
    public List<TipoTalle> getTiposTalle(){
        return tipoTalleServicio.getTiposTalle();
    }
}
