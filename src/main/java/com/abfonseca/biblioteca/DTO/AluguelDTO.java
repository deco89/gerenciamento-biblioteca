package com.abfonseca.biblioteca.DTO;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.AluguelEntity;

public class AluguelDTO {

    private Long id;
    private Long usuarioId;
    private Long livroId;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataDevolucao;

    public AluguelDTO(AluguelEntity aluguel) {
        BeanUtils.copyProperties(aluguel, this);
        this.id = aluguel.getId();
        this.usuarioId = aluguel.getUsuarioEntity().getId();
        this.livroId = aluguel.getLivroEntity().getId();
        this.dataAluguel = aluguel.getDataAluguel();
        this.dataDevolucao = aluguel.getDataDevolucao();
    }   

    public AluguelDTO() {}    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Long getLivroId() {
        return livroId;
    }
    public void setLivroId(Long livroId) {
        this.livroId = livroId;
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
