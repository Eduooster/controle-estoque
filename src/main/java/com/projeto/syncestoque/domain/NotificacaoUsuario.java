package com.projeto.syncestoque.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "notificacao_usuario_e")
public class NotificacaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacaoUsuario;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    private String lido;
    private LocalDate dataNotificacao;
}
