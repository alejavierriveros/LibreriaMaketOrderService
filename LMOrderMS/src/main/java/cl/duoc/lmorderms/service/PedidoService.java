package cl.duoc.lmorderms.service;

import cl.duoc.lmorderms.model.*;
import cl.duoc.lmorderms.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido order){

        // VALIDACIONES BÁSICAS

        if(order.getProductosIds() == null || order.getProductosIds().isEmpty()){
            throw new RuntimeException("Debe ingresar productos");
        }

        // REGLAS DE NEGOCIO (sin consumo externo aún)

        order.setEstado("CREADO");

        //  ENVÍO
        order.getEnvio().setEstadoEnvio("PENDIENTE");

        // 🧾 FACTURA
        Factura factura = new Factura();
        factura.setNumeroFactura("FAC-" + System.currentTimeMillis());
        factura.setFecha(java.time.LocalDate.now().toString());
        factura.setMonto(order.getTotal()); // luego lo calculas tú

        order.setFactura(factura);

        return pedidoRepository.save(order);
    }

    public java.util.List<Pedido> listar(){
        return pedidoRepository.findAll();
    }

    public Pedido buscar(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public void eliminar(Long id){
        pedidoRepository.deleteById(id);
    }
}