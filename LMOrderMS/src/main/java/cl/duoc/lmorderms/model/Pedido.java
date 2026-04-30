package cl.duoc.lmorderms.model;

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

    @NotBlank(message = "El userId es obligatorio")
    private String userId;

    
    @ElementCollection
    @CollectionTable(name = "order_productos", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "producto_id")
    @NotEmpty(message = "Debe agregar al menos un producto")
    private List<Long> productosIds;

    @Positive(message = "El total debe ser mayor a 0")
    private double total;

    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "envio_id")
    @NotNull(message = "El envío es obligatorio")
    private Envio envio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private Factura factura;
}