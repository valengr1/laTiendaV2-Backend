package ingSoftware.laTienda.service;

import ingSoftware.laTienda.controller.CondicionTributariaControlador;
import ingSoftware.laTienda.model.Cliente;
import ingSoftware.laTienda.repository.ClienteRepositorio;
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
        Cliente clienteEncontrado = clienteRepositorio.findClienteByDNI(cliente.getDNI());
        if (clienteEncontrado != null) {
            return "El cliente que desea registrar ya se encuentra registrado";
        } else{
            clienteRepositorio.save(cliente);
            return "Cliente registrado";
        }

    }
}
