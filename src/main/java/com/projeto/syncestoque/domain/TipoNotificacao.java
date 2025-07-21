package com.projeto.syncestoque.domain;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;


@Entity
//@EqualsAndHashCode(of= "idTipNotificacao")
@Table(name = "tipoNotificacao_e")
public class TipoNotificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipNotification;

    private String nome;

    @ManyToMany(mappedBy = "tiposNotificacao")
    private Set<Usuario> usuarios = new HashSet<>();


}
