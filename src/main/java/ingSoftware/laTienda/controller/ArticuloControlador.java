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

    //busca y obtiene todos los artículos.
    @GetMapping("/api/articulo/listar")
    public List<Articulo> getArticulos() {
        return articuloServicio.findAll();
    }

    //busca y obtiene el artículo independientemente de su estado: eliminado lógicamente o no.
    @GetMapping("/api/articulo/buscarArticuloByCodigo")
    public Articulo getArticuloByCodigo(@RequestParam Long codigo){
        return articuloServicio.getArticuloByCodigo(codigo);
    }

    //busca y obtiene el artículo si no está eliminado lógicamente.
    @GetMapping("/api/articulo/buscarArticuloByCodigoAndEstado")
    public Articulo getArticuloByCodigoAndEstado(@RequestParam Long codigo){
        return articuloServicio.getArticuloByCodigoAndEstado(codigo);
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
