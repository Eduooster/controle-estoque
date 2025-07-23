package com.projeto.syncestoque.services;


import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.repositories.UsuarioRepository;
import com.projeto.syncestoque.web.dto.DadosListaUsuario;
import com.projeto.syncestoque.web.mapperDtoToDomain.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarUsuarios {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Qualifier("usuarioMapperImpl")
    @Autowired
    private UsuarioMapper mapper;

    public Page<DadosListaUsuario> listar(Pageable pageable) {
       return usuarioRepository
               .findAllByAtivoTrue(pageable)
               .map(mapper::toListaDto);
    }
}
