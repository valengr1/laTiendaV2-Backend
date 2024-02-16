package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.TipoTalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTalleRepositorio extends JpaRepository<TipoTalle, Long> {
}
