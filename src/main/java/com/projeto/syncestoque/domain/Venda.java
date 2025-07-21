package com.projeto.syncestoque.domain;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

//@EqualsAndHashCode(of= "idVenda")
@Entity
@Table(name = "venda_e")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    private BigDecimal valorTotal;
    private LocalDateTime dataVenda;

}
