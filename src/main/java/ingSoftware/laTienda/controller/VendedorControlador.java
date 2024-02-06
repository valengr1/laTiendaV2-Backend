package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.service.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin("http://localhost:5173")
public class VendedorControlador {
    private VendedorServicio vendedorServicio;
    @Autowired
    public VendedorControlador(VendedorServicio vendedorServicio){
        this.vendedorServicio = vendedorServicio;
    }
    @GetMapping("/vendedor")
    public String getVendedor(@RequestParam Long legajo, @RequestParam String contraseña){
        return vendedorServicio.buscarPorLegajoYContraseña(legajo, contraseña);
    }
}
