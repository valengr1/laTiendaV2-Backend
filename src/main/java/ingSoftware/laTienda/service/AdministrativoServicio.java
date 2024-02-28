package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Administrativo;
import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.repository.AdministrativoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrativoServicio {
    AdministrativoRepositorio administrativoRepositorio;
    @Autowired
    public AdministrativoServicio(AdministrativoRepositorio administrativoRepositorio){
        this.administrativoRepositorio = administrativoRepositorio;
    }

    public List<Administrativo> listarAdministrativos(){
        return administrativoRepositorio.findAll();
    }

    public String buscarPorLegajoYContraseña(Long legajo, String contraseña) {
        Administrativo administrativoEncontrado = administrativoRepositorio.findByLegajoAndContraseña(legajo, contraseña);
        if(administrativoEncontrado == null){
            return "No autorizado";
        }
        else{
            return "Bienvenido " + administrativoEncontrado.getNombre();
        }
    }

    public String buscarPorLegajo(Long legajo) {
        Administrativo administrativoEncontrado = administrativoRepositorio.findByLegajo(legajo);
        if(administrativoEncontrado == null){
            return "No existe el administrativo";
        }
        else{
            return "Existe el administrativo";
        }
    }
}
