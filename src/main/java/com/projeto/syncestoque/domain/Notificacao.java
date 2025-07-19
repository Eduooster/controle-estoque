package com.projeto.syncestoque.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacao;
    private String titulo;
    private LocalDate dataNotificacao;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_tipo_notificacao")
    private TipoNotificacao tipoNotificacao;
}
