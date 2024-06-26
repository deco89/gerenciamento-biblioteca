package com.abfonseca.biblioteca.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.AluguelDTO;
import com.abfonseca.biblioteca.entity.AluguelEntity;
import com.abfonseca.biblioteca.entity.LivroEntity;
import com.abfonseca.biblioteca.entity.UsuarioEntity;
import com.abfonseca.biblioteca.enums.AluguelStatus;
import com.abfonseca.biblioteca.enums.LivroStatus;
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

    public AluguelDTO buscarAluguelPorId(Long id) {
        return new AluguelDTO(aluguelRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluguel não encontrado")));
    }
    
    public void alugarLivro(Long usuarioId, Long livroId) {
        UsuarioEntity usuarioEntity = usuarioepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        LivroEntity livroEntity = livroRepository.findById(livroId).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if(livroEntity.getLivroStatus() == LivroStatus.ALUGADO) {
            throw new IllegalStateException("Este livro já está alugado");
        }
            AluguelEntity aluguelEntity = new AluguelEntity();
            aluguelEntity.setUsuarioEntity(usuarioEntity);
            aluguelEntity.setLivroEntity(livroEntity);
            aluguelEntity.setDataAluguel(LocalDateTime.now());
            aluguelEntity.setPrazoDeDevolucao(LocalDateTime.now().plusWeeks(1));

            livroEntity.setLivroStatus(LivroStatus.ALUGADO);    
            aluguelEntity.setAluguelStatus(AluguelStatus.ABERTO);
            livroRepository.save(livroEntity);
            aluguelRepository.save(aluguelEntity);

    }

    public void devolverLivro(Long livroId) {
        
        LivroEntity livroEntity = livroRepository.findById(livroId).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));        
        AluguelEntity aluguelEntity = aluguelRepository.findByLivroEntity(livroEntity).orElseThrow(() -> new RuntimeException("Aluguel não encontrado!"));

        if(aluguelEntity.getAluguelStatus() == AluguelStatus.FINALIZADO) {
            throw new IllegalStateException("Este livro já foi devolvido");
        }
            aluguelEntity.setDataDevolucao(LocalDateTime.now().plusWeeks(3));            
            
            livroEntity.setLivroStatus(LivroStatus.DISPONIVEL);
            aluguelEntity.setAluguelStatus(AluguelStatus.FINALIZADO);
            livroRepository.save(livroEntity);
            aluguelRepository.save(aluguelEntity);               
    }

    // public void multaDeAtraso() {

    //     List<AluguelEntity> alugueis = aluguelRepository.findAll();
    //     alugueis.forEach(aluguel -> {
    //         if(aluguel.getAluguelStatus() == AluguelStatus.ABERTO) {
    //             if(aluguel.getPrazoDeDevolucao() ) {

    //             }
    //         }
    //     });
    // }
}
