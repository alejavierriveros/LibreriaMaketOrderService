package cl.duoc.lmorderms.controller;

import cl.duoc.lmorderms.dtos.*;
import cl.duoc.lmorderms.mappers.*;
import cl.duoc.lmorderms.service.*;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public PedidoDTO crear(@RequestBody @Valid PedidoDTO dto){
        return service.crear(dto)
        ;
    }

    @GetMapping
    public java.util.List<PedidoDTO> listar(){
        return service.listar()
                .stream()
                .map(PedidoMappers::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PedidoDTO obtener(@PathVariable Long id){
        return PedidoMappers.toDTO(service.buscar(id));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        service.eliminar(id);
        return "Eliminado";
    }
}
