package com.projeto.syncestoque.web.controller;

import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.infra.DadosTokenJwt;
import com.projeto.syncestoque.infra.security.TokenService;
import com.projeto.syncestoque.web.dto.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity autenticar(@RequestBody  DadosAutenticacao dados) {
        var Authtoken  = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authenticaction = manager.authenticate(Authtoken);
        var tokenJwt  = tokenService.gerarToken((Usuario) authenticaction.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));

    }
}
