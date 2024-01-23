package ingSoftware.laTienda.repositorio;

import ingSoftware.laTienda.modelo.CondicionTributaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionTributariaRepositorio extends JpaRepository<CondicionTributaria, Long> {
}
