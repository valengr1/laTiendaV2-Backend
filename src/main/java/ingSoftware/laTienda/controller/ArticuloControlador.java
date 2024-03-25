package ingSoftware.laTienda.controller;
import ingSoftware.laTienda.model.Articulo;
import ingSoftware.laTienda.service.ArticuloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class ArticuloControlador {
    ArticuloServicio articuloServicio;
    @Autowired
    public ArticuloControlador(ArticuloServicio articuloServicio) {
        this.articuloServicio = articuloServicio;
    }
    //busca y obtiene todos los artículos.
    @GetMapping("/api/articulos")
    public List<Articulo> getArticulos() {
        return articuloServicio.findAll();
    }

    //busca y obtiene el artículo independientemente de su estado: eliminado lógicamente o no.
    @GetMapping("/api/articulos/buscarArticuloByCodigo")
    public Articulo getArticuloByCodigo(@RequestParam Long codigo){
        return articuloServicio.getArticuloByCodigo(codigo);
    }

    //busca y obtiene el artículo si no está eliminado lógicamente.
    @GetMapping("/api/articulos/{codigo}")
    public ResponseEntity<?> getArticulo(@PathVariable Long codigo){
        return articuloServicio.getArticuloByCodigoAndEstado(codigo);
    }

    @PostMapping("/api/articulos")
    public String agregarArticulo(@RequestBody Articulo articulo){
        return articuloServicio.agregarArticulo(articulo);
    }

    @PutMapping("/api/articulos")
    public ResponseEntity<?> modificarArticulo(@RequestBody Articulo articulo){
        return articuloServicio.modificarArticulo(articulo);
    }

    @DeleteMapping("/api/articulos/{codigo}")
    public ResponseEntity<Articulo> eliminarArticuloByCodigo(@PathVariable Long codigo){
        return articuloServicio.eliminarArticuloByCodigo(codigo);
    }
}
