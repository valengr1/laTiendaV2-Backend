package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Administrativo;
import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.repository.AdministrativoRepositorio;
import ingSoftware.laTienda.utils.BCrypt;
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

    public Administrativo buscarPorLegajoYContraseña(Long legajo, String contraseña) {
        Administrativo adminEncontrado = administrativoRepositorio.findByLegajo(legajo);
        if(adminEncontrado == null){
            return null;
        }
        else {
            Boolean contraseñasCoinciden = BCrypt.checkpw(contraseña, administrativoRepositorio.findByLegajo(legajo).getContraseña());
            if (contraseñasCoinciden) {
                Administrativo administrativo = administrativoRepositorio.findByLegajo(legajo);
                return administrativo;
            } else {
                return null;
            }
        }
    }

    public Administrativo buscarPorLegajo(Long legajo) {
        return administrativoRepositorio.findByLegajo(legajo);
    }

    public Administrativo crearAdministrativo(Administrativo administrativo) {
        Administrativo adminEncontrado = administrativoRepositorio.findByLegajo(administrativo.getLegajo());
        if (adminEncontrado != null) {
            return null;
        } else {
            administrativo.setContraseña(BCrypt.hashpw(administrativo.getContraseña(), BCrypt.gensalt()));
            return administrativoRepositorio.save(administrativo);
        }
    }
}
