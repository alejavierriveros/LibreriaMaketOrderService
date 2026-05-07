package cl.duoc.lmorderms.mappers;

import cl.duoc.lmorderms.dtos.PedidoDTO;
import cl.duoc.lmorderms.models.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMappers {

    public static PedidoDTO toDTO(Pedido p){
        if(p == null) return null;

        PedidoDTO dto = new PedidoDTO();
//        dto.setId(p.getId());
        dto.setClienteId(p.getClienteId());
        dto.setProductosIds(p.getProductosIds());
//        dto.setTotal(p.getTotal());
//        dto.setEstado(p.getEstado());
        return dto;
    }

    public static Pedido toEntity(PedidoDTO dto, double total){
        if(dto == null) return null;

        Pedido p = new Pedido();

        p.setClienteId(dto.getClienteId());
        p.setProductosIds(dto.getProductosIds());
        p.setTotal(total);

        return p;
    }
}