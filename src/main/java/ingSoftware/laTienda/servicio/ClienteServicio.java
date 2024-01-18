package ingSoftware.laTienda.servicio;

import ingSoftware.laTienda.modelo.Cliente;
import ingSoftware.laTienda.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    ClienteRepositorio clienteRepositorio;
    @Autowired
    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente obtenerClienteByDNI(Long DNI) {
        return clienteRepositorio.findClienteByDNI(DNI);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepositorio.findAll();
    }
}
