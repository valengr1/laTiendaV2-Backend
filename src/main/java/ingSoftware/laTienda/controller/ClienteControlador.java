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

    @GetMapping("/api/clientes")
    public List<Cliente> obtenerClientes() {
        return clienteServicio.obtenerClientes();
    }

    @GetMapping("/api/clientes/{numeroDocumento}")
    public Cliente buscarClientePorDni(@PathVariable String numeroDocumento) {
        return clienteServicio.obtenerCliente(Long.parseLong(numeroDocumento));
    }

    @PostMapping("/api/clientes")
    public String registrar(@RequestBody Cliente cliente) {
        return clienteServicio.registrar(cliente);
    }
}
