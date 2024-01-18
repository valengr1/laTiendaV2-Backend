package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.modelo.Vendedor;
import ingSoftware.laTienda.repositorio.VendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorServicio {
    private VendedorRepositorio vendedorRepositorio;
    @Autowired
    public VendedorServicio(VendedorRepositorio vendedorRepositorio){
        this.vendedorRepositorio = vendedorRepositorio;
    }
    public String buscarPorLegajoYContraseña(Long legajo, String contraseña) {
        Vendedor vendedorEncontrado = vendedorRepositorio.findByLegajoAndContraseña(legajo, contraseña);
        if(vendedorEncontrado == null){
            return "Usuario y/o contraseña incorrectos";
        }
        else{
            return "Bienvenido " + vendedorEncontrado.getNombre();
        }
    }
}
