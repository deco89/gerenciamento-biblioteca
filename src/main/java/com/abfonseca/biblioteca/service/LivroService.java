package com.abfonseca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.LivroDTO;
import com.abfonseca.biblioteca.entity.LivroEntity;
import com.abfonseca.biblioteca.enums.LivroStatus;
import com.abfonseca.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    
    public List<LivroDTO> listarTodosLivros() {
        List<LivroEntity> livro = livroRepository.findAll();
        return livro.stream().map(LivroDTO::new).toList();
    }
    
    public LivroDTO buscarLivroPorId(Long id) {
        return new LivroDTO(livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado")));
    }

    public void inserirLivro(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity(livro);
        livroEntity.setLivroStatus(LivroStatus.DISPONIVEL);
        livroRepository.save(livroEntity);
    }

    public LivroDTO alterarLivro(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity(livro);
        return new LivroDTO(livroRepository.save(livroEntity));
    }

    public void deletarLivro(Long id) {
        LivroEntity livroEntity = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livreo não encontrado"));
        livroRepository.delete(livroEntity);
    }

}
