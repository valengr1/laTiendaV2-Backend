package ingSoftware.laTienda.repositorio;

import ingSoftware.laTienda.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.DNI = ?1")
    Cliente findClienteByDNI(Long DNI);
}
