package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.PuntoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoVentaRepositorio extends JpaRepository<PuntoVenta, Long> {
}
