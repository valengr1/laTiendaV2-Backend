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

    @GetMapping("/api/clientes/{dni}")
    public Cliente buscarClientePorDni(@PathVariable String dni) {
        return clienteServicio.obtenerClienteByDNI(Long.parseLong(dni));
    }

    @PostMapping("/api/clientes")
    public String registrarCliente(@RequestBody Cliente cliente) {
        return clienteServicio.registrarCliente(cliente);
    }
}
