package com.abfonseca.biblioteca.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.abfonseca.biblioteca.DTO.UsuarioDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ab_usuario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "usuarioEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AluguelEntity> alugueis;

    public UsuarioEntity(Long id, String nome, String login, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    //Faz a conversão de um Entity para DTO
    public UsuarioEntity(UsuarioDTO usuario) {
        BeanUtils.copyProperties(usuario, this);
    }
}
