package cl.duoc.lmorderms.controller;

import cl.duoc.lmorderms.model.*;
import cl.duoc.lmorderms.service.*;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido crear(@Valid @RequestBody Pedido pedido){
        return pedidoService.crearPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listar(){
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Long id){
        return pedidoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        pedidoService.eliminar(id);
        return "Pedido eliminado";
    }
}
