package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.controlador.CondicionTributariaControlador;
import ingSoftware.laTienda.modelo.Cliente;
import ingSoftware.laTienda.modelo.CondicionTributaria;
import ingSoftware.laTienda.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    ClienteRepositorio clienteRepositorio;
    CondicionTributariaControlador condicionTributariaControlador;
    @Autowired
    public ClienteServicio(ClienteRepositorio clienteRepositorio, CondicionTributariaControlador condicionTributariaControlador) {
        this.clienteRepositorio = clienteRepositorio;
        this.condicionTributariaControlador = condicionTributariaControlador;
    }

    public Cliente obtenerClienteByDNI(Long DNI) {
        return clienteRepositorio.findClienteByDNI(DNI);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepositorio.findAll();
    }

    public String registrarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
        return "Cliente registrado";
    }
}
