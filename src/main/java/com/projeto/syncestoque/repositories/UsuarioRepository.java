package com.projeto.syncestoque.repositories;

import com.projeto.syncestoque.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByEmail(String username);

    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
}
