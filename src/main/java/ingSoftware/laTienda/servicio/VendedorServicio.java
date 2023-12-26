package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.controlador.VendedorControlador;
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
    public Vendedor buscarPorLegajoYContraseña(Long legajo, String contraseña) {
        return vendedorRepositorio.findByLegajoAndContraseña(legajo, contraseña);
    }
}
