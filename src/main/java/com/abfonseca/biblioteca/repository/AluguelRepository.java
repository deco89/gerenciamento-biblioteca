package com.abfonseca.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abfonseca.biblioteca.entity.AluguelEntity;
import com.abfonseca.biblioteca.entity.LivroEntity;

public interface AluguelRepository extends JpaRepository<AluguelEntity, Long>{

    Optional<AluguelEntity> findByLivroEntity(LivroEntity livroEntity);
}
