package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Marca;
import ingSoftware.laTienda.repository.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServicio {
    MarcaRepositorio marcaRepositorio;

    @Autowired
    public MarcaServicio(MarcaRepositorio marcaRepositorio){
        this.marcaRepositorio = marcaRepositorio;
    }

    public List<Marca> getMarcas(){
        return marcaRepositorio.findAll();
    }
}
