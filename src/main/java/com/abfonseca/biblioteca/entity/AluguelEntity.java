package com.abfonseca.biblioteca.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ab_aluguel")
public class AluguelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private LivroEntity livroEntity;

    private LocalDateTime dataAluguel;
    
    private LocalDateTime dataDevolucao;

    public AluguelEntity() {
    }
    
    public AluguelEntity(Long id, UsuarioEntity usuarioEntity, LivroEntity livroEntity, LocalDateTime dataAluguel,
            LocalDateTime dataDevolucao) {
        this.id = id;
        this.usuarioEntity = usuarioEntity;
        this.livroEntity = livroEntity;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }
    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
    public LivroEntity getLivroEntity() {
        return livroEntity;
    }
    public void setLivroEntity(LivroEntity livroEntity) {
        this.livroEntity = livroEntity;
    }
    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }
    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }
    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
