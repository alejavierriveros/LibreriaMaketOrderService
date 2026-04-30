package cl.duoc.lmorderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.lmorderms.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
