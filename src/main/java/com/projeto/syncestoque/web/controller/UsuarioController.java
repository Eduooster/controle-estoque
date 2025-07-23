package com.projeto.syncestoque.web.controller;



import com.projeto.syncestoque.domain.Usuario;

import com.projeto.syncestoque.services.CadastrarUsuario;
import com.projeto.syncestoque.services.DeletarUsuario;
import com.projeto.syncestoque.services.DetalharUsuario;
import com.projeto.syncestoque.services.ListarUsuarios;
import com.projeto.syncestoque.web.dto.DadosCadastroUsuario;
import com.projeto.syncestoque.web.dto.DadosDetalhamentoUsuario;
import com.projeto.syncestoque.web.dto.DadosListaUsuario;
import com.projeto.syncestoque.web.mapperDtoToDomain.UsuarioMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {



    private final UsuarioMapper mapper;
    private final CadastrarUsuario cadastrarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final DeletarUsuario deletarUsuario;
    private final DetalharUsuario detalharUsuario;

    public UsuarioController(
            @Qualifier("usuarioMapperImpl") UsuarioMapper mapper,
            CadastrarUsuario cadastrarUsuario,
            ListarUsuarios listarUsuarios,
            DeletarUsuario deletarUsuario,
            DetalharUsuario detalharUsuario
    ) {
        this.mapper = mapper;
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.deletarUsuario = deletarUsuario;
        this.detalharUsuario = detalharUsuario;
    }


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder)
    {
        Usuario cadastroNovoUsuario = cadastrarUsuario.cadastrar(mapper.toDomain(dados));
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(cadastroNovoUsuario.getIdUsuario()).toUri();
        DadosDetalhamentoUsuario dto = mapper.toDetalhamentoDto(cadastroNovoUsuario);


        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(
                dto.idUsuario(),
                dto.nome(),
                dto.email(),
                dto.role()));
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Page<DadosListaUsuario>> listar(
            @PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {

        var page = listarUsuarios.listar(paginacao);
        System.out.println(page);

        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id ) {
        deletarUsuario.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        DadosDetalhamentoUsuario  dto = detalharUsuario.detalhar(id);
        System.out.println(dto);
        return ResponseEntity.ok(dto);
    }






}
