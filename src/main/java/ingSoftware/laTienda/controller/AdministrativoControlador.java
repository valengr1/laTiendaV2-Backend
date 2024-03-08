package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Administrativo;
import ingSoftware.laTienda.service.AdministrativoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class AdministrativoControlador {
    AdministrativoServicio administrativoServicio;
    @Autowired
    public AdministrativoControlador(AdministrativoServicio administrativoServicio){
        this.administrativoServicio = administrativoServicio;
    }

    @GetMapping("/api/administrativo")
    public List<Administrativo> listarAdministrativos(){
        return administrativoServicio.listarAdministrativos();
    }

    @PostMapping("/api/administrativo/crear")
    public Administrativo crearAdministrativo(@RequestBody Administrativo administrativo){
        return administrativoServicio.crearAdministrativo(administrativo);
    }

    @PostMapping("/api/administrativo")
    public Administrativo buscarByLegajoAndContraseña(@RequestBody Administrativo administrativo){
        return administrativoServicio.buscarPorLegajoYContraseña(administrativo.getLegajo(),administrativo.getContraseña());
    }

    @PostMapping("/api/administrativo/{legajo}")
    public Administrativo buscarByLegajo(@PathVariable Long legajo){
        return administrativoServicio.buscarPorLegajo(legajo);
    }





}
