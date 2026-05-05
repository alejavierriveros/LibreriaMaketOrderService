package cl.duoc.lmorderms.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;
    private String titulo;
    private String autor;
    private Double precio;
    private Integer stock;
}