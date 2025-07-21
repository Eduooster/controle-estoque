package com.projeto.syncestoque.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
//@EqualsAndHashCode(of= "idItemVenda")

@Table(name = "item_venda_e")
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemVenda;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    private int quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;


}
