package ingSoftware.laTienda.repositorio;

import ingSoftware.laTienda.modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, Long> {
    @Query("SELECT a FROM Articulo a WHERE a.codigo = ?1")
    Articulo findArticuloByCodigo(Long codigo);
}
