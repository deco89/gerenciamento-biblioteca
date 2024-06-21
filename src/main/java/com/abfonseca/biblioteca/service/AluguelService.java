package com.abfonseca.biblioteca.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.AluguelDTO;
import com.abfonseca.biblioteca.entity.AluguelEntity;
import com.abfonseca.biblioteca.entity.LivroEntity;
import com.abfonseca.biblioteca.entity.UsuarioEntity;
import com.abfonseca.biblioteca.repository.AluguelRepository;
import com.abfonseca.biblioteca.repository.LivroRepository;
import com.abfonseca.biblioteca.repository.UsuarioRepository;

@Service
public class AluguelService {

    @Autowired  
    private AluguelRepository aluguelRepository;

    @Autowired
    private UsuarioRepository usuarioepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<AluguelDTO> listarTodosAlugueis() {
        List<AluguelEntity> alugueis = aluguelRepository.findAll();
        return alugueis.stream().map(AluguelDTO::new).toList();
    }

    public void alugarLivro(Long usuarioId, Long livroId) {
        UsuarioEntity usuario = usuarioepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        LivroEntity livro = livroRepository.findById(livroId).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        AluguelEntity aluguel = new AluguelEntity();
        aluguel.setUsuarioEntity(usuario);
        aluguel.setLivroEntity(livro);
        aluguel.setDataAluguel(LocalDateTime.now());
        aluguel.setDataDevolucao(LocalDateTime.now().plusDays(14));

        aluguelRepository.save(aluguel);
    }

    public void devolverLivro(Long aluguelId) {
        AluguelEntity aluguel = aluguelRepository.findById(aluguelId).orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
        aluguel.setDataDevolucao(LocalDateTime.now());
        aluguelRepository.save(aluguel);
    }
}
