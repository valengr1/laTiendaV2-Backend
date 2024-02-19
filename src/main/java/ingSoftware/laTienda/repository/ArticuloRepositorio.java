package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, Long> {
    @Query("SELECT a FROM Articulo a WHERE a.codigo = ?1")
    Articulo findArticuloByCodigo(Long codigo);

    @Query("SELECT a FROM Articulo a WHERE a.codigo = ?1 and a.deleted = false")
    Articulo getArticuloByCodigoAndEstado(Long codigo);
}
