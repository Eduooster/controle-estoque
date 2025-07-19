package com.projeto.syncestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_e")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String role;



}
