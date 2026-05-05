package cl.duoc.lmorderms.mappers;

import cl.duoc.lmorderms.dto.*;
import cl.duoc.lmorderms.model.*;

public class EnvioMapper {

    public static EnvioDTO toDTO(Envio e){
        if(e == null) return null;
        EnvioDTO dto = new EnvioDTO();
        dto.setId(e.getId());
        dto.setDireccion(e.getDireccion());
        dto.setCiudad(e.getCiudad());
        dto.setEstadoEnvio(e.getEstadoEnvio());
        return dto;
    }

    public static Envio toEntity(EnvioDTO dto){
        if(dto == null) return null;
        Envio e = new Envio();
        e.setId(dto.getId());
        e.setDireccion(dto.getDireccion());
        e.setCiudad(dto.getCiudad());
        return e;
    }
}