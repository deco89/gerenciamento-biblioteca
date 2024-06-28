package com.abfonseca.biblioteca.DTO;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.PerfilEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDTO {

    private Long id;
    private String descricao;


    public PerfilDTO(PerfilEntity perfilEntity) {
        BeanUtils.copyProperties(perfilEntity, this);
    }
}
