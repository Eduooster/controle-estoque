package com.projeto.syncestoque.services;


import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.repositories.UsuarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;

import java.util.Optional;

@Service
public class CadastrarUsuario {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrar(Usuario usuario) {
        Optional<Usuario> usuarioExiste = usuarioRepository.findByEmail(usuario.getUsername());

        if (usuarioExiste.isPresent()) {
            throw new RuntimeException("usuario ja existe");//personalizar excessao
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        usuario.setAtivo(true);

        usuarioRepository.save(usuario);

        return usuario;


    }
}
