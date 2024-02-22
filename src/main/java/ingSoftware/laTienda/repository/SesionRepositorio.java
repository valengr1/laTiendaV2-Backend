package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepositorio extends JpaRepository<Sesion, Long> {
}
