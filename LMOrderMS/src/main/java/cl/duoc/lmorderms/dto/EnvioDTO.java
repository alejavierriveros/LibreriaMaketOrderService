package cl.duoc.lmorderms.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDTO {

    private Long id;
    private String direccion;
    private String ciudad;
    private String estadoEnvio;
}