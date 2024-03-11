package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Marca;
import ingSoftware.laTienda.service.MarcaServicio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class MarcaControlador {
    MarcaServicio marcaServicio;

    public MarcaControlador(MarcaServicio marcaServicio){
        this.marcaServicio = marcaServicio;
    }
    @GetMapping("/api/marcas")
    public List<Marca> getMarcas(){
        return marcaServicio.getMarcas();
    }
}
