package ingSoftware.laTienda.service;

import ingSoftware.laTienda.model.Administrativo;
import ingSoftware.laTienda.model.PuntoVenta;
import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.repository.PuntoVentaRepositorio;
import ingSoftware.laTienda.repository.VendedorRepositorio;
import ingSoftware.laTienda.utils.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorServicio {
    private final VendedorRepositorio vendedorRepositorio;
    private PuntoVentaRepositorio puntoVentaRepositorio;
    @Autowired
    public VendedorServicio(VendedorRepositorio vendedorRepositorio, PuntoVentaRepositorio puntoVentaRepositorio){
        this.vendedorRepositorio = vendedorRepositorio;
        this.puntoVentaRepositorio = puntoVentaRepositorio;
    }

    public Vendedor buscarPorLegajoYContraseña(Long legajo, String contraseña) {
        Vendedor vendedorEncontrado = vendedorRepositorio.findByLegajo(legajo);
        if(vendedorEncontrado == null){
            return null;
        }
        else {
            Boolean contraseñasCoinciden = BCrypt.checkpw(contraseña, vendedorRepositorio.findByLegajo(legajo).getContraseña());
            if (contraseñasCoinciden) {
                Vendedor vendedor = vendedorRepositorio.findByLegajo(legajo);
                return vendedor;
            } else {
                return null;
            }
        }
    }

    public List<Vendedor> listar() {
        return vendedorRepositorio.findAll();
    }

    public Vendedor buscarPorLegajo(Long legajo) {
        return vendedorRepositorio.findByLegajo(legajo);
    }

    public Vendedor crearVendedor(Vendedor vendedor) {
        //se busca el punto de venta por id y, si se encuentra, se lo setea al vendedor
        puntoVentaRepositorio.findById( vendedor.getPuntoVenta().getId() ).ifPresent(vendedor::setPuntoVenta);
        //se encripta la contraseña proporcionada
        vendedor.setContraseña(BCrypt.hashpw(vendedor.getContraseña(), BCrypt.gensalt()));
        return vendedorRepositorio.save(vendedor);
    }
}
