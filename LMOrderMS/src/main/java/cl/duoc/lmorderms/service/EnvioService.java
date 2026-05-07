package cl.duoc.lmorderms.service;

import cl.duoc.lmorderms.models.*;
import cl.duoc.lmorderms.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public Envio guardar(Envio envio){

        // VALIDACIONES
        if(envio.getDireccion() == null || envio.getDireccion().isEmpty()){
            throw new RuntimeException("Dirección obligatoria");
        }

        if(envio.getCiudad() == null || envio.getCiudad().isEmpty()){
            throw new RuntimeException("Ciudad obligatoria");
        }

        // REGLA DE NEGOCIO
        envio.setEstadoEnvio("PENDIENTE");

        return envioRepository.save(envio);
    }

    public Envio actualizarEstado(Long id, String estado){

        Envio envio = envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado"));

        // REGLA DE NEGOCIO (flujo de estados)
        if(estado.equals("ENTREGADO") && envio.getEstadoEnvio().equals("PENDIENTE")){
            throw new RuntimeException("No puede pasar directo a ENTREGADO");
        }

        envio.setEstadoEnvio(estado);
        return envioRepository.save(envio);
    }

    public Envio buscar(Long id){
        return envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado"));
    }
}