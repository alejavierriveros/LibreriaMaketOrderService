package cl.duoc.lmorderms.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private Integer numrun;
    private String dvrun;
    private String pnombre;
    private String appaterno;
    private String email;
}