package ingSoftware.laTienda.service;

import ingSoftware.laTienda.DTOs.ArticuloDTO;
import ingSoftware.laTienda.model.Articulo;
import ingSoftware.laTienda.repository.ArticuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServicio {
    ArticuloRepositorio articuloRepositorio;
    @Autowired
    public ArticuloServicio(ArticuloRepositorio articuloRepositorio) {
        this.articuloRepositorio = articuloRepositorio;
    }
    public ArticuloDTO findArticuloByCodigo(Long codigo) {
        ArticuloDTO articuloDTO = new ArticuloDTO();
        Articulo articuloEncontrado = articuloRepositorio.findArticuloByCodigo(codigo);
        if(articuloEncontrado == null) {
            return null;
        }
        articuloDTO.setCodigo(articuloEncontrado.getCodigo());
        articuloDTO.setDescripcion(articuloEncontrado.getDescripcion());
        articuloDTO.setMarca(articuloEncontrado.getMarca().getDescripcion());
        articuloDTO.setCategoria(articuloEncontrado.getCategoria().getDescripcion());
        articuloDTO.setPrecio(articuloEncontrado.getPrecio());
        articuloDTO.setTipoTalle(articuloEncontrado.getTipoTalle().getDescripcion());
        return articuloDTO;
    }

    public List<Articulo> findAll() {
        return articuloRepositorio.findAll();
    }

    public String agregarArticulo(Articulo articulo) {
        Articulo articuloEnDB = articuloRepositorio.findArticuloByCodigo(articulo.getCodigo());
        if(articuloEnDB == null){
            articuloRepositorio.save(articulo);
            return "Artículo agregado correctamente";
        } else{
            return "Ya existe un artículo con el código " + articulo.getCodigo();
        }
    }
    public String modificarArticulo(Articulo articulo) {
        Articulo articuloExistente = articuloRepositorio.findArticuloByCodigo(articulo.getCodigo());
        if(articuloExistente == null){
            return "No existe el artículo con código " + articulo.getCodigo();
        }
        articuloRepositorio.save(articulo);
        return "Articulo modificado correctamente";
    }

    public String eliminarArticuloByCodigo(Long codigo) {
        Articulo articuloExistente = articuloRepositorio.findArticuloByCodigo(codigo);
        if(articuloExistente == null){
            return "No existe el artículo con código " + codigo;
        }
        articuloRepositorio.deleteById(codigo);
        return "Articulo eliminado correctamente";
    }

    public Articulo getArticuloByCodigo(Long codigo) {
        return articuloRepositorio.findArticuloByCodigo(codigo);
    }
}
