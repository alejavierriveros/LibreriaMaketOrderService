package cl.duoc.lmorderms.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private Long id;
    private String numeroFactura;
    private String fecha;
    private double monto;
}
