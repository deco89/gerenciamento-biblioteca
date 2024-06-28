package com.abfonseca.biblioteca.entity;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.DTO.RecursoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ab_recurso")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RecursoEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String chave;

    public RecursoEntity(RecursoDTO recursoDTO) {
        BeanUtils.copyProperties(recursoDTO, this);
    }
}
