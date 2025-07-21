package com.projeto.syncestoque.domain;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

//@EqualsAndHashCode(of= "idNotificacaoUsuario")
@Table(name = "notificacao_usuario_e")

//essa classe é uma entidade separada, que registra notificações efetivamente enviadas para usuários específicos.
//Ela serve para:
//Armazenar quando uma notificação foi enviada a um usuário.
// Marcar se a notificação foi lida ou não.
//Associar a notificação a um usuário específico (possivelmente com mais detalhes).

public class NotificacaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacaoUsuario;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    private String lido;
    private LocalDateTime dataNotificacao;
}
