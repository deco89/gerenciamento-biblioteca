package com.abfonseca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abfonseca.biblioteca.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

}
