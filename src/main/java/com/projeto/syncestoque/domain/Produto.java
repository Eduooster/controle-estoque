package com.projeto.syncestoque.domain;

import jakarta.persistence.*;


@Entity

//@EqualsAndHashCode(of= "idProduto")
@Table(name="produto_e")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double precoProduto;
    private int quantidade_estoque;
    private CategoriaProduto categoriaProduto;
}
