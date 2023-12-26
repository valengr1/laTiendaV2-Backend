package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.modelo.Articulo;
import ingSoftware.laTienda.repositorio.ArticuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServicio {
    ArticuloRepositorio articuloRepositorio;
    @Autowired
    public ArticuloServicio(ArticuloRepositorio articuloRepositorio) {
        this.articuloRepositorio = articuloRepositorio;
    }
    public Articulo findArticuloByCodigo(Long codigo) {
        return articuloRepositorio.findArticuloByCodigo(codigo);
    }

    public List<Articulo> findAll() {
        return articuloRepositorio.findAll();
    }
}
