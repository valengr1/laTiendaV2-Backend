package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Vendedor;
import ingSoftware.laTienda.service.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class VendedorControlador {
    private VendedorServicio vendedorServicio;
    @Autowired
    public VendedorControlador(VendedorServicio vendedorServicio){
        this.vendedorServicio = vendedorServicio;
    }

    @GetMapping("/api/vendedor")
    public List<Vendedor> listar(){
        return vendedorServicio.listar();
    }

    @PostMapping("/api/vendedor/crear")
    public Vendedor crearVendedor(@RequestBody Vendedor vendedor){
        return vendedorServicio.crearVendedor(vendedor);
    }

    @PostMapping("/api/vendedor")
    public Vendedor getVendedor(@RequestBody Vendedor vendedor){
        return vendedorServicio.buscarPorLegajoYContraseña(vendedor.getLegajo(), vendedor.getContraseña());
    }

    @PostMapping("/api/vendedor/{legajo}")
    public Vendedor buscarByLegajo(@PathVariable Long legajo){
        return vendedorServicio.buscarPorLegajo(legajo);
    }


}
