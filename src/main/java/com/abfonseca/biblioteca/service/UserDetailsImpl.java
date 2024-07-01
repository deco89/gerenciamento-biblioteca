package com.abfonseca.biblioteca.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.abfonseca.biblioteca.entity.UsuarioEntity;

public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    public UserDetailsImpl(Long id, String name, String username, String password, String email,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }
    public static UserDetailsImpl build(UsuarioEntity usuario) {
        return new UserDetailsImpl(
            usuario.getId(), 
            usuario.getNome(), 
            usuario.getLogin(),
            usuario.getSenha(),
            usuario.getEmail(), 
            new ArrayList<>());
    }    
    
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
