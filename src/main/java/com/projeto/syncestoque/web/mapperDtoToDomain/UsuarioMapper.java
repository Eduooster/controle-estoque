package com.projeto.syncestoque.web.mapperDtoToDomain;


import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.web.dto.DadosCadastroUsuario;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toDomain(DadosCadastroUsuario dto);
}
