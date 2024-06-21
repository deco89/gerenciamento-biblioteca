package com.abfonseca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abfonseca.biblioteca.entity.AluguelEntity;

public interface AluguelRepository extends JpaRepository<AluguelEntity, Long>{

}
