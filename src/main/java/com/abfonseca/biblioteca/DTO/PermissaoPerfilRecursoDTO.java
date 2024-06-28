package com.abfonseca.biblioteca.DTO;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.entity.PermissaoPerfilRecursoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDTO {

    private Long id;
    private PerfilDTO perfil;
    private RecursoDTO recurso;

    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
        BeanUtils.copyProperties(permissaoPerfilRecurso, this);
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecursoEntity() != null) {
            this.recurso = new RecursoDTO(permissaoPerfilRecurso.getRecursoEntity());
        }
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfilEntity() != null) {
            this.perfil = new PerfilDTO(permissaoPerfilRecurso.getPerfilEntity());
        }
    }



}
