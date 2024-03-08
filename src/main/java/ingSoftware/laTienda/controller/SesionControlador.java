package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Sesion;
import ingSoftware.laTienda.model.Vendedor;
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

    @GetMapping("/api/sesion/buscarSesionByLegajoEmpleado")
    public String getSesionByLegajo(@RequestParam Long legajo){
        return sesionServicio.getSesionByLegajo(legajo);
    }

    @PostMapping("/api/sesion")
    public String postSesion(@RequestBody Vendedor vendedor){
        return sesionServicio.postSesion(vendedor.getLegajo(),vendedor.getContraseña());
    }

    @DeleteMapping("/api/sesion/eliminar")
    public String deleteSesion(@RequestParam Long legajo){
        return sesionServicio.deleteSesion(legajo);
    }
}
