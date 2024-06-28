package com.abfonseca.biblioteca.DTO;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.RecursoEntity;

public class RecursoDTO {

    private Long id;
    private String nome;
    private String chave;

    public RecursoDTO() {
    }

    public RecursoDTO(RecursoEntity recursoEntity) {
        BeanUtils.copyProperties(recursoEntity, this);
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
    public String getChave() {
        return chave;
    }
    public void setChave(String chave) {
        this.chave = chave;
    }
}
