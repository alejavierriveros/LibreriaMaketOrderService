package cl.duoc.lmorderms.service;

import cl.duoc.lmorderms.models.*;
import cl.duoc.lmorderms.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura generarFactura(double monto){

        if(monto <= 0){
            throw new RuntimeException("Monto inválido");
        }

        Factura factura = new Factura();
        factura.setNumeroFactura("FAC-" + System.currentTimeMillis());
        factura.setFecha(java.time.LocalDate.now().toString());
        factura.setMonto(monto);

        return facturaRepository.save(factura);
    }

    public Factura buscar(Long id){
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }
}