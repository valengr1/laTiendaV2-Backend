package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Categoria;
import ingSoftware.laTienda.repository.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio {
    CategoriaRepositorio categoriaRepositorio;
    @Autowired
    public CategoriaServicio(CategoriaRepositorio categoriaRepositorio){
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public List<Categoria> getCategorias(){
        return categoriaRepositorio.findAll();
    }
}
