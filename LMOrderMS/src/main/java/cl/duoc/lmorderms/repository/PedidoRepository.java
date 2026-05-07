package cl.duoc.lmorderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.lmorderms.models.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}