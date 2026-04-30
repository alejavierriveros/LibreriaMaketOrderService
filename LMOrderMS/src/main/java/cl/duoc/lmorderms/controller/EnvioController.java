package cl.duoc.lmorderms.controller;

import cl.duoc.lmorderms.model.*;
import cl.duoc.lmorderms.service.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping("/{id}")
    public Envio obtener(@PathVariable Long id){
        return envioService.buscar(id);
    }

    @PutMapping("/{id}/estado")
    public Envio actualizarEstado(@PathVariable Long id, @RequestParam String estado){
        return envioService.actualizarEstado(id, estado);
    }
}
