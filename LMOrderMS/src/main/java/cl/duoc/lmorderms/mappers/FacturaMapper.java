package cl.duoc.lmorderms.mappers;

import cl.duoc.lmorderms.dto.*;
import cl.duoc.lmorderms.model.*;

public class FacturaMapper {

    public static FacturaDTO toDTO(Factura f){
        if(f == null) return null;
        FacturaDTO dto = new FacturaDTO();
        dto.setId(f.getId());
        dto.setNumeroFactura(f.getNumeroFactura());
        dto.setFecha(f.getFecha());
        dto.setMonto(f.getMonto());
        return dto;
    }
}
