package org.example.instancias;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Venda venda;

    private Double valorPago;
    private String formaPagamento;
    private Boolean status;
}
