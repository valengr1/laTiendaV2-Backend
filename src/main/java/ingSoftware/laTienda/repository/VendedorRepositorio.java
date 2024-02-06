package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositorio extends JpaRepository<Vendedor, Long> {
    @Query("SELECT v FROM Vendedor v WHERE v.legajo = ?1 AND v.contraseña = ?2")
    Vendedor findByLegajoAndContraseña(Long legajo, String contraseña);

    @Query("SELECT v FROM Vendedor v WHERE v.legajo = ?1")
    Vendedor findByLegajo(Long legajoVendedor);
}
