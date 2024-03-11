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

    @GetMapping("/api/administrativos")
    public List<Administrativo> listarAdministrativos(){
        return administrativoServicio.listarAdministrativos();
    }

    @GetMapping("/api/administrativos/{legajo}")
    public Administrativo buscarByLegajo(@PathVariable Long legajo){
        return administrativoServicio.buscarPorLegajo(legajo);
    }

    @PostMapping("/api/administrativos")
    public Administrativo buscarByLegajoAndContraseña(@RequestBody Administrativo administrativo){
        return administrativoServicio.buscarPorLegajoYContraseña(administrativo.getLegajo(),administrativo.getContraseña());
    }







}
