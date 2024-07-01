package com.abfonseca.biblioteca.service;

import java.time.Instant;
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
            aluguelEntity.setDataAluguel(Instant.now());
            aluguelEntity.setPrazoDeDevolucao(Instant.now().plusSeconds(129600));

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
            aluguelEntity.setDataDevolucao(Instant.now().plusSeconds(1814499));            
            
            livroEntity.setLivroStatus(LivroStatus.DISPONIVEL);
            aluguelEntity.setAluguelStatus(AluguelStatus.FINALIZADO);
            livroRepository.save(livroEntity);
            aluguelRepository.save(aluguelEntity);               
    }

    // public void multaDeAtraso(Long id) {

    //     double multa = 0;
    //     double multaFixa = 3.0;
    //     double multaVariavel = 1.0;
    //     int contadorDeDias = 0;
        
    //     AluguelEntity aluguelEntity = aluguelRepository.findById(id).orElseThrow(() -> new RuntimeException("Alguel não encontrado"));
        
    //     long diasDeAtraso = aluguelEntity.getDataAluguel();

    //     while (aluguelEntity.getDataAluguel().isBefore(Instant.now())) {
    //         contadorDeDias++;
    //         aluguelEntity.getDataAluguel().plusSeconds(86400);
    //     }
        
    //     while (aluguelEntity.getAluguelStatus() == AluguelStatus.ABERTO) {
    //         aluguelEntity.getDataAluguel().
    //     }

    //     if(aluguelEntity != null) {
    //         if(aluguelEntity.getAluguelStatus() == AluguelStatus.ABERTO) {
    //             if(aluguelEntity.getPrazoDeDevolucao().compareTo(Instant.now()) >= 0) {
    //                 multa += multaFixa;
    //                 multa += multaVariavel * diasDeAtraso;
    //             }
    //         }
    //     }
    // }
}
