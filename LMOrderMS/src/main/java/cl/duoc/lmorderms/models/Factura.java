package cl.duoc.lmorderms.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "facturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;
    private String fecha;
    private double monto;
}