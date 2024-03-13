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

    public Cliente obtenerCliente(Long numeroDocumento) {
        return clienteRepositorio.findCliente(numeroDocumento);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepositorio.findAll();
    }

    public String registrar(Cliente cliente) {
        String tipoDocumento = cliente.getTipoDocumento().getValue();
        String numeroDocumento = cliente.getNumeroDocumento().toString();
        if(tipoDocumento.equals("DNI") && (numeroDocumento.length() != 8 || !cliente.getCondicionTributaria().getDescripcion().equals("Consumidor Final"))){
            return "El numero de documento debe tener 8 digitos y la condicion tributaria debe ser Consumidor Final";
        } else if(tipoDocumento.equals("CUIT") && numeroDocumento.length() != 11){
            return "El numero de documento debe tener 11 digitos";
        } else if(tipoDocumento.equals("CUIL") && numeroDocumento.length() != 11){
            return "El numero de documento debe tener 11 digitos";
        }  else{
            Cliente clienteEncontrado = clienteRepositorio.findCliente(cliente.getNumeroDocumento());
            if (clienteEncontrado != null) {
                return "Ya existe un cliente con el numero de documento: "+cliente.getNumeroDocumento();
            } else{
                clienteRepositorio.save(cliente);
                return "Cliente registrado";
            }
        }
    }
}
