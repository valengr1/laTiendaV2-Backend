package ingSoftware.laTienda.controlador;

import ingSoftware.laTienda.modelo.Cliente;
import ingSoftware.laTienda.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @CrossOrigin("http://localhost:5173")
public class ClienteControlador {
    ClienteServicio clienteServicio;
    @Autowired
    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }
    @GetMapping("/buscarCliente")
    public Cliente obtenerCliente(@RequestParam String DNI) {
        return clienteServicio.obtenerClienteByDNI(Long.parseLong(DNI));
    }

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
        return clienteServicio.obtenerClientes();
    }
}
