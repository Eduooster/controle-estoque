package com.projeto.syncestoque.web.dto;

import com.projeto.syncestoque.domain.Usuario;

public record DadosListaUsuario(Long idUsuario, String nome, String email, String role) {

    public DadosListaUsuario(Usuario usuario) {
        this(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(),usuario.getRole());
    }
}
