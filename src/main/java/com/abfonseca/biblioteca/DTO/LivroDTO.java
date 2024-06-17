package com.abfonseca.biblioteca.DTO;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.LivroEntity;

public class LivroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String descricao;
    private String editora;
    private Long usuario_id;

    public LivroDTO(LivroEntity livro) {
        BeanUtils.copyProperties(livro, this);
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.descricao = livro.getDescricao();
        this.editora = livro.getEditora();
        this.usuario_id = livro.getUsuario().getId();
    }

    public LivroDTO(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

}
