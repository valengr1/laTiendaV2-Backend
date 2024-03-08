package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Sesion;
import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.repository.SesionRepositorio;
import ingSoftware.laTienda.repository.VendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class SesionServicio {
    SesionRepositorio sesionRepositorio;
    VendedorRepositorio vendedorRepositorio;

    @Autowired
    public SesionServicio(SesionRepositorio sesionRepositorio, VendedorRepositorio vendedorRepositorio){
        this.sesionRepositorio = sesionRepositorio;
        this.vendedorRepositorio = vendedorRepositorio;
    }

    public List<Sesion> getSesiones(){
        return sesionRepositorio.findAll();
    }

    public String postSesion(Long legajoVendedor, String password) {
        LocalDate fechaActual = LocalDate.now();
        Vendedor v = vendedorRepositorio.findByLegajo(legajoVendedor);
        List<Sesion> sesiones = sesionRepositorio.findAll();
        boolean sesionExistente = false;
        for(Sesion s : sesiones){
            if (s.getVendedor().getLegajo().equals(legajoVendedor)) {
                sesionExistente = true;
                break;
            }
        }
        if(sesionExistente){
           return "Ya existe una sesión registrada con el legajo: "+legajoVendedor;
        } else{
            if(v != null){
                Sesion sesion = new Sesion();
                sesion.setFecha(fechaActual);
                sesion.setVendedor(v);
                sesionRepositorio.save(sesion);
                return "Sesión guardada";
            } else {
                return "Legajo y/o contraseña del vendedor incorrecto/a";
            }
        }
    }

    public String deleteSesion(Long legajoVendedor) {
        List<Sesion> sesiones = sesionRepositorio.findAll();
        boolean sesionEncontrada = false;
        Long idSesion = 0L;
        for(Sesion sesion : sesiones){
            if(sesion.getVendedor().getLegajo().equals(legajoVendedor)){
                sesionEncontrada = true;
                idSesion = sesion.getId();
                break;
            }
        }
        if(sesionEncontrada && idSesion != 0){
            sesionRepositorio.deleteById(idSesion);
            return "Sesión eliminada correctamente";
        } else{
            return "No existe una sesión iniciada con el legajo: "+legajoVendedor;
        }

    }

    public String getSesionByLegajo(Long legajo) {
        List<Sesion> sesiones = getSesiones();
        boolean sesionEncontrada = false;
        for (Sesion sesion : sesiones){
            if (sesion.getVendedor().getLegajo().equals(legajo)) {
                sesionEncontrada = true;
                break;
            }
        }
        if(sesionEncontrada){
            return "Ya existe un inicio de sesión con el legajo: "+legajo;
        } else {
            return "No existe una sesión iniciada con el legajo: "+legajo;
        }
    }
}
