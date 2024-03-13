package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepositorio extends JpaRepository<Comprobante, Integer> {
    @Query("SELECT MAX(c.numero) FROM Comprobante c")
    Integer obtenerUltimoNumeroComprobante();
}
