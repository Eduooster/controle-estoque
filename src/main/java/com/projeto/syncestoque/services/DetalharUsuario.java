package com.projeto.syncestoque.services;

import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.repositories.UsuarioRepository;
import com.projeto.syncestoque.web.dto.DadosDetalhamentoUsuario;
import com.projeto.syncestoque.web.mapperDtoToDomain.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper mapper;

    public DadosDetalhamentoUsuario detalhar(Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return mapper.toDetalhamentoDto(usuario);
    }
}
