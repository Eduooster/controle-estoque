package com.projeto.syncestoque.repositories;

import com.projeto.syncestoque.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    UserDetails findByEmail(String email);
}
