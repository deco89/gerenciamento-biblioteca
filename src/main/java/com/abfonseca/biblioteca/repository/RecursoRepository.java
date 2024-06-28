package com.abfonseca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abfonseca.biblioteca.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

    

}
