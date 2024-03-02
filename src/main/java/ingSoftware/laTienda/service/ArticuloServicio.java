package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Articulo;
import ingSoftware.laTienda.repository.ArticuloRepositorio;
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
    public List<Articulo> findAll() {
        return articuloRepositorio.findAll();
    }
    public String agregarArticulo(Articulo articulo) {
        Articulo articuloEnDB = articuloRepositorio.findArticuloByCodigo(articulo.getCodigo());
        if(articuloEnDB != null){
            if(articuloEnDB.getDeleted()){
                return "No se puede agregar un artículo con el código: "+articulo.getCodigo(); //ya que existe un artículo con el mismo código pero eliminado lógicamente
            } else{
                return "Ya existe un artículo con el código: "+articulo.getCodigo();
            }
        } else{
            if(articulo.getMargenGanancia() > 0 && articulo.getMargenGanancia() <= 1){
                //registramos el articulo
                articulo.setDeleted(false);
                articuloRepositorio.save(articulo);
                return "Artículo agregado correctamente";
            } else{
                return "El margen de ganancia debe tener un valor mayor que 0 y menor o igual a 1";
            }
        }
        //return "No se pudo agregar el artículo";
    }
    public String modificarArticulo(Articulo articulo) {
        Articulo articuloExistente = articuloRepositorio.findArticuloByCodigo(articulo.getCodigo());
        if(articuloExistente == null){
            return "No existe el artículo con código " + articulo.getCodigo();
        }
        if(articulo.getMargenGanancia() > 0 && articulo.getMargenGanancia() <= 1){
            articulo.setDeleted(false);
            articuloRepositorio.save(articulo);
            return "Articulo modificado correctamente";
        } else{
            return "El margen de ganancia debe tener un valor mayor que 0 y menor o igual a 1";
        }
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
    public Articulo getArticuloByCodigoAndEstado(Long codigo) {
        return articuloRepositorio.getArticuloByCodigoAndEstado(codigo);
    }
}
