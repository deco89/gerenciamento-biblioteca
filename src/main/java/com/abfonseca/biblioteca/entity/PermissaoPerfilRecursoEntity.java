package com.abfonseca.biblioteca.entity;

import com.abfonseca.biblioteca.DTO.PermissaoPerfilRecursoDTO;

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
@Table(name = "ab_permissao_perfil_recurso")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissaoPerfilRecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfilEntity;

    @ManyToOne
    @JoinColumn(name = "id_recurso")
    private RecursoEntity recursoEntity;

    public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        if(permissaoPerfilRecursoDTO != null && permissaoPerfilRecursoDTO.getRecurso() != null) {
            this.recursoEntity = new RecursoEntity(permissaoPerfilRecursoDTO.getRecurso());
        }
        if(permissaoPerfilRecursoDTO != null && permissaoPerfilRecursoDTO.getPerfil() != null) {
            this.perfilEntity = new PerfilEntity(permissaoPerfilRecursoDTO.getPerfil());
        }
    }
}
