package cl.duoc.lmorderms.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private Long userId;
    private List<Long> productosIds;
    private double total;
    private String estado;
    private EnvioDTO envio;
    private FacturaDTO factura;
}