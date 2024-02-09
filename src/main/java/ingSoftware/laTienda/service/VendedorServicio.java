package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.repository.VendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorServicio {
    private final VendedorRepositorio vendedorRepositorio;
    @Autowired
    public VendedorServicio(VendedorRepositorio vendedorRepositorio){
        this.vendedorRepositorio = vendedorRepositorio;
    }
    public String buscarPorLegajoYContraseña(Long legajo, String contraseña) {
        Vendedor vendedorEncontrado = vendedorRepositorio.findByLegajoAndContraseña(legajo, contraseña);
        if(vendedorEncontrado == null){
            return "No autorizado";
        }
        else{
            return "Bienvenido " + vendedorEncontrado.getNombre();
        }
    }
}
