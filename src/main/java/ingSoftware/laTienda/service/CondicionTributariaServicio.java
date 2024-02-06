package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.CondicionTributaria;
import ingSoftware.laTienda.repository.CondicionTributariaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionTributariaServicio {
    CondicionTributariaRepositorio condicionTributariaRepositorio;
    @Autowired
    public CondicionTributariaServicio(CondicionTributariaRepositorio condicionTributariaRepositorio) {
        this.condicionTributariaRepositorio = condicionTributariaRepositorio;
    }
    public List<CondicionTributaria> obtenerCondicionesTributarias() {
        return condicionTributariaRepositorio.findAll();
    }
}
