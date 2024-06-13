package com.abfonseca.biblioteca.service;

import java.util.List;

import com.abfonseca.biblioteca.DTO.LivroDTO;
import com.abfonseca.biblioteca.entity.LivroEntity;
import com.abfonseca.biblioteca.repository.LivroRepository;

public class LivroService {

    private LivroRepository livroRepository;

    public List<LivroDTO> listarTodosLivros() {
        List<LivroEntity> livro = livroRepository.findAll();
        return livro.stream().map(LivroDTO::new).toList();
    }

    public void inserirLivro(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity(livro);
        livroRepository.save(livroEntity);
    }

    public LivroDTO alterarLivro(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity(livro);
        return new LivroDTO(livroRepository.save(livroEntity));
    }

    public void deletarLivro(Long id) {
        LivroEntity livroEntity = livroRepository.findById(id).get();
        livroRepository.delete(livroEntity);
    }

    public LivroDTO buscarLivroPorId(Long id) {
        return new LivroDTO(livroRepository.findById(id).get());
    }
}
