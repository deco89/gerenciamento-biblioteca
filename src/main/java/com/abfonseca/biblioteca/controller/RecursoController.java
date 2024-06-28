package com.abfonseca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abfonseca.biblioteca.DTO.RecursoDTO;
import com.abfonseca.biblioteca.service.RecursoService;

@RestController
@RequestMapping(value = "/recurso")
@CrossOrigin
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<RecursoDTO> listarTodos() {
        return recursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public RecursoDTO buscarRecursoPorId(@PathVariable Long id) {
        return recursoService.buscarRecursoPorId(id);
    }

    @PostMapping
    public void inserirRecruso(@RequestBody RecursoDTO recursoDTO) {
        recursoService.inserirRecurso(recursoDTO);
    }

    @PutMapping
    public RecursoDTO alterarRecurso(@RequestBody RecursoDTO recursoDTO) {
        return recursoService.alterarRecurso(recursoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRecurso(@PathVariable Long id) {
        recursoService.deletarRecurso(id);
        return ResponseEntity.ok().build();
    }
}
