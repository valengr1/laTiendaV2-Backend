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

    @GetMapping("/api/sesiones")
    public List<Sesion> getSesiones(){
        return sesionServicio.getSesiones();
    }

    @GetMapping("/api/sesiones/buscarSesionByLegajoEmpleado")
    public String getSesionByLegajo(@RequestParam Long legajo){
        return sesionServicio.getSesionByLegajo(legajo);
    }

    @PostMapping("/api/sesiones")
    public String postSesion(@RequestBody Vendedor vendedor){
        return sesionServicio.postSesion(vendedor.getLegajo(),vendedor.getContraseña());
    }

    @DeleteMapping("/api/sesiones/{legajo}")
    public String deleteSesion(@PathVariable Long legajo){
        return sesionServicio.deleteSesion(legajo);
    }
}
