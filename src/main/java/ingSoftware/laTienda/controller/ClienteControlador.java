package ingSoftware.laTienda.controller;

import ingSoftware.laTienda.model.Cliente;
import ingSoftware.laTienda.service.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class ClienteControlador {
    ClienteServicio clienteServicio;
    @Autowired
    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }
    @GetMapping("/api/cliente/buscarByDNI")
    public Cliente obtenerCliente(@RequestParam String DNI) {
        return clienteServicio.obtenerClienteByDNI(Long.parseLong(DNI));
    }
    @GetMapping("/api/clientes")
    public List<Cliente> obtenerClientes() {
        return clienteServicio.obtenerClientes();
    }

    @PostMapping("/api/cliente/registrar")
    public String registrarCliente(@RequestBody Cliente cliente) {
        return clienteServicio.registrarCliente(cliente);
    }
}
