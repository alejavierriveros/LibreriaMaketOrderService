package cl.duoc.lmorderms.controller;

import cl.duoc.lmorderms.model.*;
import cl.duoc.lmorderms.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/{id}")
    public Factura obtener(@PathVariable Long id){
        return facturaService.buscar(id);
    }
}