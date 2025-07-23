package com.projeto.syncestoque.web.mapperDtoToDomain;


import com.projeto.syncestoque.domain.Usuario;
import com.projeto.syncestoque.web.dto.DadosDetalhamentoUsuario;
import com.projeto.syncestoque.web.dto.DadosCadastroUsuario;
import com.projeto.syncestoque.web.dto.DadosListaUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "senha", source = "senha")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "role", source = "role")
    Usuario toDomain(DadosCadastroUsuario dto);

    @Mapping(source = "email", target = "email")
    DadosDetalhamentoUsuario toDetalhamentoDto(Usuario usuario);

    DadosListaUsuario toListaDto(Usuario usuario);


}
