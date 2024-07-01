package com.abfonseca.biblioteca.DTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.UsuarioEntity;
import com.abfonseca.biblioteca.enums.TipoSituacaoUsuario;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;   
    private String senha;
    private String email;
    private TipoSituacaoUsuario situacao;
    private List<AluguelDTO> alugueis;

    //Faz a conversão de um usuarioDTO para uma entidade.
    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
        this.alugueis = usuario.getAlugueis().stream().map(AluguelDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO() {        
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<AluguelDTO> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<AluguelDTO> alugueis) {
        this.alugueis = alugueis;
    }

    public TipoSituacaoUsuario getSituacao() {
        return situacao;
    }

    public void setSituacao(TipoSituacaoUsuario situacao) {
        this.situacao = situacao;
    }
}
