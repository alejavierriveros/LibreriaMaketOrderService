package cl.duoc.lmorderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.lmorderms.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}