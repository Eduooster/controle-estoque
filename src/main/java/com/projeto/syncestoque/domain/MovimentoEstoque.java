package com.projeto.syncestoque.domain;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "movimento_estoque_e")
//@EqualsAndHashCode(of= "idMovimento")
public class MovimentoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimento;
    private TipoMovimentoEstoque tipoMovimento;
    private int quantidade;
    private LocalDateTime dataMovimento;
    private Long idUsuario;


}
