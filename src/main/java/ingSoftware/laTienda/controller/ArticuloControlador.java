package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.DTOs.ArticuloDTO;
import ingSoftware.laTienda.model.Articulo;
import ingSoftware.laTienda.service.ArticuloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class ArticuloControlador {
    ArticuloServicio articuloServicio;
    @Autowired
    public ArticuloControlador(ArticuloServicio articuloServicio) {
        this.articuloServicio = articuloServicio;
    }
    @GetMapping("/api/articulo/buscarByCodigo")
    public ArticuloDTO getArticulo(@RequestParam Long codigo) {
        return articuloServicio.findArticuloByCodigo(codigo);
    }

    @GetMapping("/api/articulo/listar")
    public List<Articulo> getArticulos() {
        return articuloServicio.findAll();
    }

    @GetMapping("/api/articulo/buscarArticuloByCodigo")
    public Articulo getArticuloByCodigo(@RequestParam Long codigo){
        return articuloServicio.getArticuloByCodigo(codigo);
    }
    @PostMapping("/api/articulo/agregar")
    public String agregarArticulo(@RequestBody Articulo articulo){
        return articuloServicio.agregarArticulo(articulo);
    }

    @PutMapping("/api/articulo/modificar")
    public String modificarArticulo(@RequestBody Articulo articulo){
        return articuloServicio.modificarArticulo(articulo);
    }

    @DeleteMapping("/api/articulo/eliminarArticuloByCodigo")
    public String eliminarArticuloByCodigo(@RequestParam Long codigo){
        return articuloServicio.eliminarArticuloByCodigo(codigo);
    }
}
