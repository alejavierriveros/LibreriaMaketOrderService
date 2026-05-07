package cl.duoc.lmorderms.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long clienteId;


    @ElementCollection
    @CollectionTable(name = "order_productos", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "producto_id")
    @NotEmpty
    private List<Long> productosIds;

    private double total;

//    private String estado;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "envio_id")
//    @NotNull
//    private Envio envio;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "factura_id")
//    private Factura factura;
}