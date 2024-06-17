package com.abfonseca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.LivroDTO;
import com.abfonseca.biblioteca.entity.LivroEntity;
import com.abfonseca.biblioteca.entity.UsuarioEntity;
import com.abfonseca.biblioteca.repository.LivroRepository;
import com.abfonseca.biblioteca.repository.UsuarioRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<LivroDTO> listarTodosLivros() {
        List<LivroEntity> livro = livroRepository.findAll();
        return livro.stream().map(LivroDTO::new).toList();
    }

    public void inserirLivro(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity(livro);
        UsuarioEntity usuarioEntity = usuarioRepository.findById(livro.getUsuario_id()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        livroEntity.setUsuario(usuarioEntity);
        livroRepository.save(livroEntity);
    }

    public LivroDTO alterarLivro(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity(livro);
        UsuarioEntity usuarioEntity = usuarioRepository.findById(livro.getUsuario_id()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        livroEntity.setUsuario(usuarioEntity);
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
