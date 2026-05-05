package cl.duoc.lmorderms.service;

import cl.duoc.lmorderms.dto.*;
import cl.duoc.lmorderms.model.*;
import cl.duoc.lmorderms.repository.*;
import cl.duoc.lmorderms.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    public Pedido crear(Pedido o){

        // VALIDAR USUARIO
        UserDTO user = restTemplate.getForObject(
            "http://localhost:8081/api/users/" + o.getUserId(),
            UserDTO.class
        );

        if(user == null){
            throw new ResourceNotFoundException("Usuario no existe");
        }

        double total = 0;

        // VALIDAR PRODUCTOS
        for(Long id : o.getProductosIds()){

            ProductoDTO p = restTemplate.getForObject(
                "http://localhost:8082/api/products/" + id,
                ProductoDTO.class
            );

            if(p == null){
                throw new ResourceNotFoundException("Producto no encontrado: " + id);
            }

            if(p.getStock() <= 0){
                throw new BadRequestException("Producto sin stock: " + p.getTitulo());
            }

            total += p.getPrecio();
        }

        if(total <= 0){
            throw new BadRequestException("Total inválido");
        }

        o.setTotal(total);
        o.setEstado("CREADO");

        //  ENVÍO
        o.getEnvio().setEstadoEnvio("PENDIENTE");

        //  FACTURA
        Factura f = new Factura();
        f.setNumeroFactura("FAC-" + System.currentTimeMillis());
        f.setFecha(java.time.LocalDate.now().toString());
        f.setMonto(total);

        o.setFactura(f);

        return repo.save(o);
    }

    public java.util.List<Pedido> listar(){
        return repo.findAll();
    }

    public Pedido buscar(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }
}