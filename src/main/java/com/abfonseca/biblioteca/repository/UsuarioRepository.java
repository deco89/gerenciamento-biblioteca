package com.abfonseca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abfonseca.biblioteca.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
