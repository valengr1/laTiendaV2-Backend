package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.TipoTalle;
import ingSoftware.laTienda.repository.TipoTalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTalleServicio {
    TipoTalleRepositorio tipoTalleRepositorio;
    @Autowired
    public TipoTalleServicio(TipoTalleRepositorio tipoTalleRepositorio){
        this.tipoTalleRepositorio = tipoTalleRepositorio;
    }

    public List<TipoTalle> getTiposTalle(){
        return tipoTalleRepositorio.findAll();
    }
}
