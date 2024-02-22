package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Sesion;
import ingSoftware.laTienda.service.SesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class SesionControlador {
    SesionServicio sesionServicio;
    @Autowired
    public SesionControlador(SesionServicio sesionServicio){
        this.sesionServicio = sesionServicio;
    }

    @GetMapping("/api/sesion/listar")
    public List<Sesion> getSesiones(){
        return sesionServicio.getSesiones();
    }

    @PostMapping("/api/sesion/agregar")
    public String postSesion(@RequestParam Long legajo, @RequestParam String password){
        return sesionServicio.postSesion(legajo,password);
    }

    @DeleteMapping("/api/sesion/eliminar")
    public String deleteSesion(@RequestParam Long legajo){
        return sesionServicio.deleteSesion(legajo);
    }
}
