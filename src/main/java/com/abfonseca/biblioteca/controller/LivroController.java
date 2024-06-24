package com.abfonseca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abfonseca.biblioteca.DTO.LivroDTO;
import com.abfonseca.biblioteca.service.LivroService;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroDTO> listarTodosLivros() {
        return livroService.listarTodosLivros();
    }

    @PostMapping
    public void inserirLivro(@RequestBody LivroDTO livro) {
        livroService.inserirLivro(livro);
    }

    @PutMapping
    public LivroDTO alterarLivro(@RequestBody LivroDTO livro) {
        return livroService.alterarLivro(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public LivroDTO buscarLivroPorId(@PathVariable Long id) {
        return livroService.buscarLivroPorId(id);
    }
}
