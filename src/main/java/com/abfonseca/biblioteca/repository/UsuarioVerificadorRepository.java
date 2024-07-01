package com.abfonseca.biblioteca.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abfonseca.biblioteca.entity.UsuarioVerificadorEntity;


public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long>{

    Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);;
}
