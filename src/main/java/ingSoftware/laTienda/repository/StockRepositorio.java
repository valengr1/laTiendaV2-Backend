package ingSoftware.laTienda.repository;

import ingSoftware.laTienda.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepositorio extends JpaRepository<Stock,Long> {
    @Query("SELECT s FROM Stock s where s.articulo.codigo = ?1")
    List<Stock> findByCodigoDelArticulo(Long codigo);

    @Query("SELECT s FROM Stock s where s.articulo.codigo = ?1 and s.sucursal.id = ?2")
    List<Stock> findStockByCodigoDelArticuloAndSucursalId(Long codigo, Long sucursalId);

    @Query("select s from Stock s where s.id = ?1")
    Stock findByIdStock(Long idStock);
}
