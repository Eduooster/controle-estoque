package com.projeto.syncestoque.web.controller;


import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.repositories.UsuarioRepository;
import com.projeto.syncestoque.web.dto.DadosAutenticacao;
import com.projeto.syncestoque.web.dto.DadosCadastroUsuario;
import com.projeto.syncestoque.web.mapperDtoToDomain.UsuarioMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    //deletar isso dps
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper mapper;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        usuarioRepository.save(mapper.toDomain(dados));

        return ResponseEntity.ok().build();
    }
}
