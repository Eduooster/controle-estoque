package com.projeto.syncestoque.web.controller;

import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.web.dto.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {


    @Autowired
    private AuthenticationManager manager;

    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity autenticar(@RequestBody  DadosAutenticacao dados) {
        var token  = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authenticaction = manager.authenticate(token);
        return ResponseEntity.ok(authenticaction);

    }
}
