package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Articulo;
import ingSoftware.laTienda.repository.ArticuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (articuloEnDB != null) {
            if (articuloEnDB.getDeleted()) {
                return "No se puede agregar un artículo con el código: " + articulo.getCodigo(); //ya que existe un artículo con el mismo código pero eliminado lógicamente
            } else {
                return "Ya existe un artículo con el código: " + articulo.getCodigo();
            }
        } else {
            if (articulo.getMargenGanancia() > 0 && articulo.getMargenGanancia() <= 1) {
                //registramos el articulo
                articulo.setDeleted(false);
                articuloRepositorio.save(articulo);
                return "Artículo agregado correctamente";
            } else {
                return "El margen de ganancia debe tener un valor mayor que 0 y menor o igual a 1";
            }
        }
        //return "No se pudo agregar el artículo";
    }

    public ResponseEntity<?> modificarArticulo(Articulo articulo) {
        Articulo articuloExistente = articuloRepositorio.findArticuloByCodigo(articulo.getCodigo());
        if (articuloExistente == null) {
            return new ResponseEntity<>("No existe el artículo", HttpStatus.NOT_FOUND);
        }
        if (articulo.getMargenGanancia() > 0 && articulo.getMargenGanancia() <= 1) {
            articulo.setDeleted(false);
            articuloRepositorio.save(articulo);
            return new ResponseEntity<>(articulo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("El margen de ganancia debe estar entre 0 y 1", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Articulo> eliminarArticuloByCodigo(Long codigo) {
        Articulo articuloExistente = articuloRepositorio.findArticuloByCodigo(codigo);
        if (articuloExistente == null) {
            return ResponseEntity.notFound().build();
        }
        articuloRepositorio.deleteById(codigo);
        return ResponseEntity.ok().build();
    }

    public Articulo getArticuloByCodigo(Long codigo) {
        return articuloRepositorio.findArticuloByCodigo(codigo);
    }

    public ResponseEntity<?> getArticuloByCodigoAndEstado(Long codigo) {
        Articulo articulo = articuloRepositorio.getArticuloByCodigoAndEstado(codigo);
        if (articulo == null) {
            return new ResponseEntity<>("No existe el artículo", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(articulo, HttpStatus.OK);
    }
}
