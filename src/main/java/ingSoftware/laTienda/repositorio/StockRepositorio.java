package ingSoftware.laTienda.repositorio;

import ingSoftware.laTienda.modelo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepositorio extends JpaRepository<Stock,Long> {
    @Query("SELECT s FROM Stock s where s.articulo.codigo = ?1")
    List<Stock> findByCodigoDelArticulo(Long codigo);
}
