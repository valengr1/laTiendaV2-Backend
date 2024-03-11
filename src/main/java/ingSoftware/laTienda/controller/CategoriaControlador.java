package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Categoria;
import ingSoftware.laTienda.repository.CategoriaRepositorio;
import ingSoftware.laTienda.service.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class CategoriaControlador {
    CategoriaServicio categoriaServicio;

    @Autowired
    public CategoriaControlador(CategoriaServicio categoriaServicio){
        this.categoriaServicio = categoriaServicio;
    }

    @GetMapping("/api/categorias")
    public List<Categoria> getCategorias(){
        return categoriaServicio.getCategorias();
    }
}
