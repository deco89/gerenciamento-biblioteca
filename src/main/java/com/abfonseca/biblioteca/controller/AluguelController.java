package com.abfonseca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abfonseca.biblioteca.DTO.AluguelDTO;
import com.abfonseca.biblioteca.service.AluguelService;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public List<AluguelDTO> listarTodosAlugueis() {
        return aluguelService.listarTodosAlugueis();
    }

    @PostMapping("/alugar")
    public ResponseEntity<Void> alugarLivro(@RequestParam Long usuarioId, Long livroId) {
        aluguelService.alugarLivro(usuarioId, livroId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/devolver/{id}")
    public ResponseEntity<Void> devolverLivro(@PathVariable Long id) {
        aluguelService.devolverLivro(id);
        return ResponseEntity.ok().build();
    }


}
