package com.projeto.syncestoque.infra.security;

import com.projeto.syncestoque.repositories.UsuarioRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJwt = recuperarToken(request);
        var uri = request.getRequestURI();
        System.out.println("entrou na dofilter");

        if (tokenJwt != null) {
            System.out.println("Token: " + tokenJwt);
            var subject = tokenService.getSubject(tokenJwt);
            var usuarioOptional = usuarioRepository.findByEmail(subject);
            System.out.println("Subject do token: " + subject);


            if (usuarioOptional.isPresent()) {
                var usuario = usuarioOptional.get();
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }


        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {

        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
    }
