package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Administrativo;
import ingSoftware.laTienda.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepositorio extends JpaRepository<Administrativo, Long> {
    @Query("SELECT a FROM Administrativo a WHERE a.legajo = ?1 AND a.contraseña = ?2")
    Administrativo findByLegajoAndContraseña(Long legajo, String contraseña);

    @Query("SELECT a FROM Administrativo a WHERE a.legajo = ?1")
    Administrativo findByLegajo(Long legajo);
}
