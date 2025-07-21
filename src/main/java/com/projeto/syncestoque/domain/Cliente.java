package com.projeto.syncestoque.domain;

import jakarta.persistence.*;



//@EqualsAndHashCode(of = "idCliente")
@Table(name = "cliente_e")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    private String empresa;
    private String email;
    private String telefone;
    private String status;


}
