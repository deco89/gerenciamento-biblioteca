package com.abfonseca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abfonseca.biblioteca.entity.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Long>{

}
