package com.abfonseca.biblioteca.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.DTO.LivroDTO;
import com.abfonseca.biblioteca.enums.LivroStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ab_livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String editora;
    @Enumerated(EnumType.STRING)
    private LivroStatus livroStatus;

    @OneToMany(mappedBy = "livroEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AluguelEntity> alugueis;
    
    public LivroEntity() {        
    }

    public LivroEntity(Long id, String titulo, String autor, String descricao, String editora, LivroStatus livroStatus) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.editora = editora;
        this.livroStatus = livroStatus;
    }

    public LivroEntity(LivroDTO livro) {
        BeanUtils.copyProperties(livro, this);
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
