package com.projeto.syncestoque.domain;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "usuario_e")
//@EqualsAndHashCode(of= "idProduto")

public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String role;
    private Boolean ativo;
    private Boolean deleated;


    @ManyToMany
    @JoinTable(
            name = "notificacao_usuario_e", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "usuario_id"), // FK para Usuario
            inverseJoinColumns = @JoinColumn(name = "tipo_notificacao_id") // FK para TipoNotificacao
    )
    private Set<TipoNotificacao> tiposNotificacao = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO") ,new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nome, String email, String senha, String role, Set<TipoNotificacao> tiposNotificacao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.tiposNotificacao = tiposNotificacao;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Boolean getDeleated() {
        return deleated;
    }

    public void setDeleated(Boolean deleated) {
        this.deleated = deleated;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<TipoNotificacao> getTiposNotificacao() {
        return tiposNotificacao;
    }

    public void setTiposNotificacao(Set<TipoNotificacao> tiposNotificacao) {
        this.tiposNotificacao = tiposNotificacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUsuario);
    }
}
