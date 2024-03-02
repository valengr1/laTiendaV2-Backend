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

    @GetMapping("/api/administrativo/listar")
    public List<Administrativo> listarAdministrativos(){
        return administrativoServicio.listarAdministrativos();
    }

    @GetMapping("/api/administrativo/buscarByLegajo")
    public String buscarByLegajo(@RequestParam Long legajo){
        return administrativoServicio.buscarPorLegajo(legajo);
    }

    @GetMapping("/api/administrativo/buscarByLegajoAndContraseña")
    public String buscarByLegajoAndContraseña(@RequestParam Long legajo, @RequestParam String contraseña){
        return administrativoServicio.buscarPorLegajoYContraseña(legajo,contraseña);
    }}
