package ingSoftware.laTienda.controlador;

import ingSoftware.laTienda.modelo.Vendedor;
import ingSoftware.laTienda.modelo.VendedorInicioSesion;
import ingSoftware.laTienda.servicio.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin("http://localhost:5173")
public class VendedorControlador {
    private VendedorServicio vendedorServicio;
    @Autowired
    public VendedorControlador(VendedorServicio vendedorServicio){
        this.vendedorServicio = vendedorServicio;
    }
    @GetMapping("/vendedor")
    public String vendedor(@RequestParam Long legajo, @RequestParam String contraseña){
        Vendedor v = vendedorServicio.buscarPorLegajoYContraseña(legajo, contraseña);
        if(v == null){
            return "Usuario y/o contraseña incorrecto/a";
        }
        return "Bienvenido " + v.getNombre();
    }
}
