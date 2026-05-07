package cl.duoc.lmorderms.dtos;

import jakarta.validation.constraints.Positive;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {


    @Positive
    private Long clienteId;
    private List<Long> productosIds;
//    private double total;
//    private String estado;
//    private EnvioDTO envio;
//    private FacturaDTO factura;
}