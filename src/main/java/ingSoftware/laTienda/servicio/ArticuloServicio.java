package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.DTOs.ArticuloDTO;
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
}
