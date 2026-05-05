package cl.duoc.lmorderms.mappers;

import cl.duoc.lmorderms.dto.PedidoDTO;
import cl.duoc.lmorderms.model.Pedido;

public class PedidoMappers {

    public static PedidoDTO toDTO(Pedido p){
        if(p == null) return null;

        PedidoDTO dto = new PedidoDTO();
        dto.setId(p.getId());
        dto.setUserId(p.getUserId());
        dto.setProductosIds(p.getProductosIds());
        dto.setTotal(p.getTotal());
        dto.setEstado(p.getEstado());
        return dto;
    }

    public static Pedido toEntity(PedidoDTO dto){
        if(dto == null) return null;

        Pedido p = new Pedido();
        p.setId(dto.getId());
        p.setUserId(dto.getUserId());
        p.setProductosIds(dto.getProductosIds());
        return p;
    }
}