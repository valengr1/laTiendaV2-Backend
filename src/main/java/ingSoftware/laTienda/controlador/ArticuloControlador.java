package ingSoftware.laTienda.controlador;

import ingSoftware.laTienda.DTOs.ArticuloDTO;
import ingSoftware.laTienda.modelo.Articulo;
import ingSoftware.laTienda.servicio.ArticuloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.CodingErrorAction;
import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class ArticuloControlador {
    ArticuloServicio articuloServicio;
    @Autowired
    public ArticuloControlador(ArticuloServicio articuloServicio) {
        this.articuloServicio = articuloServicio;
    }
    @GetMapping("/articulo")
    public ArticuloDTO getArticulo(@RequestParam Long codigo) {
        return articuloServicio.findArticuloByCodigo(codigo);
    }

    @GetMapping("/getArticulos")
    public List<Articulo> getArticulos() {
        return articuloServicio.findAll();
    }
}
