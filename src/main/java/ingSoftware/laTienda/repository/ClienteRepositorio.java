package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.numeroDocumento = ?1")
    Cliente findCliente(Long numeroDocumento);
}
