package com.abfonseca.biblioteca.DTO;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.LivroEntity;
import com.abfonseca.biblioteca.enums.LivroStatus;

public class LivroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String descricao;
    private String editora;
    private LivroStatus livroStatus;

    public LivroDTO(LivroEntity livro) {
        BeanUtils.copyProperties(livro, this);
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
    public LivroStatus getLivroStatus() {
        return livroStatus;
    }

    public void setLivroStatus(LivroStatus livroStatus) {
        this.livroStatus = livroStatus;
    }
}
