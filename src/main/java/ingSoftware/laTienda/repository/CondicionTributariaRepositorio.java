package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.CondicionTributaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionTributariaRepositorio extends JpaRepository<CondicionTributaria, Long> {
}
