package com.projeto.syncestoque.services;

import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletarUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void deletar(Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        if (!usuarioOptional.isPresent()) {
            throw new EntityNotFoundException("Id usuario inexistente");
        }

        usuarioOptional.get().setDeleated(false);



    }
}
