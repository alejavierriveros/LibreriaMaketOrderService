package cl.duoc.lmorderms.service;

import cl.duoc.lmorderms.clients.ToAPICatalogFeign;
import cl.duoc.lmorderms.clients.ToAPICustomerFeign;
import cl.duoc.lmorderms.dtos.*;
import cl.duoc.lmorderms.mappers.PedidoMappers;
import cl.duoc.lmorderms.models.*;
import cl.duoc.lmorderms.repository.*;
import cl.duoc.lmorderms.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;


    ClienteOrderResponseDTO clienteOrderResponseDTO;


    DireccionResponseDTO direccionResponseDTO;

    @Autowired
    ToAPICustomerFeign toAPICustomerFeign;

    @Autowired
    ToAPICatalogFeign toAPICatalogFeign;


    PedidoMappers pedidoMappers = new PedidoMappers();


    public PedidoDTO crear(PedidoDTO dto){
        clienteOrderResponseDTO =  toAPICustomerFeign.findById(dto.getClienteId());

        if (clienteOrderResponseDTO == null) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        }


        // VA
        double total = 0;

        // VALIDAR PRODUCTOS
        List<Long> productosIds = new ArrayList<>();
        for(Long id : dto.getProductosIds()){

            ProductoDTO p = toAPICatalogFeign.obtener(id);

            /*TODO: Se creará carrito de compras como un MS aparte que valide ingreso de productos uno por uno, y envíe el detalle de compra a Pedido.
            ya que la siguente fución (abajo) finalizaría el proceso si es que un producto de la lista no existe */

            if(p == null){
                throw new ResourceNotFoundException("Producto no encontrado: " + id);
            } else {
                productosIds.add(p.getId());
            }

           /*TODO: Adherido a lo anterior: Se creará carrito de compras como un MS aparte que valide ingreso de productos uno por uno, y envíe el detalle de compra a Pedido.
            ya que la siguente fución (abajo) finalizaría el proceso si es que un producto de la lista no existe */

                //Cambiar esta dfunción de producto a stock. Stock debe entregar si queda o no queda pedido. Se sacó el atributo stock en la entidad  Producto
//            if(p.getStock() <= 0){
//                throw new BadRequestException("Producto sin stock: " + p.getTitulo());
//            }

            //total += p.getPrecio(); //Ya no se pide total desde producto sino que desde carrito ya que esta entidad calcula y envía el total de toda la compra.
        }

        if(total <= 0){
            throw new BadRequestException("Total inválido");
        }


//        o.setEstado("CREADO");
//
//        //  ENVÍO
//        o.getEnvio().setEstadoEnvio("PENDIENTE");

        //  FACTURA
//        Factura f = new Factura();
//        f.setNumeroFactura("FAC-" + System.currentTimeMillis());
//        f.setFecha(java.time.LocalDate.now().toString());
//        f.setMonto(total);
//
//        o.setFactura(f);

        repo.save(pedidoMappers.toEntity(dto, total));
        return dto;
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