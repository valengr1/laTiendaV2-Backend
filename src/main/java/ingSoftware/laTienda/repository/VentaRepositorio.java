package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta,Long> {
}
