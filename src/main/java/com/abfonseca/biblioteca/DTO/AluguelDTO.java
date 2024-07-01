package com.abfonseca.biblioteca.DTO;

import java.time.Instant;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.AluguelEntity;
import com.abfonseca.biblioteca.enums.AluguelStatus;

public class AluguelDTO {

    private Long id;
    private Long usuarioId;
    private Long livroId;
    private Instant dataAluguel;
    private Instant dataDevolucao;
    private Instant prazoDeDevolucao;
    private AluguelStatus aluguelStatus;

    public AluguelDTO(AluguelEntity aluguel) {
        BeanUtils.copyProperties(aluguel, this);
        this.id = aluguel.getId();
        this.usuarioId = aluguel.getUsuarioEntity().getId();
        this.livroId = aluguel.getLivroEntity().getId();
        this.dataAluguel = aluguel.getDataAluguel();
        this.dataDevolucao = aluguel.getDataDevolucao();
        this.prazoDeDevolucao = aluguel.getPrazoDeDevolucao();
        this.aluguelStatus = aluguel.getAluguelStatus();
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
    public Instant getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Instant dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Instant getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public AluguelStatus getAluguelStatus() {
        return aluguelStatus;
    }

    public void setAluguelStatus(AluguelStatus aluguelStatus) {
        this.aluguelStatus = aluguelStatus;
    }

    public Instant getPrazoDeDevolucao() {
        return prazoDeDevolucao;
    }

    public void setPrazoDeDevolucao(Instant prazoDeDevolucao) {
        this.prazoDeDevolucao = prazoDeDevolucao;
    }    
    
}
