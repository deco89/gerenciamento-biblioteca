package com.abfonseca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.RecursoDTO;
import com.abfonseca.biblioteca.entity.RecursoEntity;
import com.abfonseca.biblioteca.repository.RecursoRepository;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;
    
    public List<RecursoDTO> listarTodos() {
        List<RecursoEntity> recursos = recursoRepository.findAll();
        return recursos.stream().map(RecursoDTO::new).toList();
    }

    public RecursoDTO buscarRecursoPorId(Long id) {
        return new RecursoDTO(recursoRepository.findById(id).orElseThrow(()-> new RuntimeException("Recurso não encontrado.")));
    }

    public void inserirRecurso(RecursoDTO recursoDTO) {
        RecursoEntity recursoEntity = new RecursoEntity(recursoDTO);
        recursoRepository.save(recursoEntity);
    }

    public RecursoDTO alterarRecurso(RecursoDTO recursoDTO) {
        RecursoEntity recursoEntity = new RecursoEntity(recursoDTO);
        return new RecursoDTO(recursoRepository.save(recursoEntity));
    } 

    public void deletarRecurso(Long id) {
        RecursoEntity recursoEntity = recursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        recursoRepository.delete(recursoEntity);
    }
}
