package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.CondicionTributaria;
import ingSoftware.laTienda.service.CondicionTributariaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class CondicionTributariaControlador {
    CondicionTributariaServicio condicionTributariaServicio;
    @Autowired
    public CondicionTributariaControlador(CondicionTributariaServicio condicionTributariaServicio) {
        this.condicionTributariaServicio = condicionTributariaServicio;
    }
    @GetMapping("/api/condicionesTributarias")
    public List<CondicionTributaria> obtenerCondicionesTributarias() {
        return condicionTributariaServicio.obtenerCondicionesTributarias();
    }
}
