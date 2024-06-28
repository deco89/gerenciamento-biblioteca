package com.abfonseca.biblioteca.entity;

import java.time.LocalDateTime;

import com.abfonseca.biblioteca.enums.AluguelStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ab_aluguel")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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

    private LocalDateTime prazoDeDevolucao;

    private AluguelStatus aluguelStatus;

    public AluguelEntity(Long id, UsuarioEntity usuarioEntity, LivroEntity livroEntity, LocalDateTime dataAluguel,
            LocalDateTime dataDevolucao, LocalDateTime prazoDeDevolucao, AluguelStatus aluguelStatus) {
        this.id = id;
        this.usuarioEntity = usuarioEntity;
        this.livroEntity = livroEntity;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.prazoDeDevolucao = prazoDeDevolucao;
        this.aluguelStatus = aluguelStatus;
    }
}
