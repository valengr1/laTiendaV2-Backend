package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepositorio extends JpaRepository<Comprobante, Integer> {
}
