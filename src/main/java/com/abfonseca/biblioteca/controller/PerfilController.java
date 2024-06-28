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

import com.abfonseca.biblioteca.DTO.PerfilDTO;
import com.abfonseca.biblioteca.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
@CrossOrigin
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilDTO> listarTodos() {
        return perfilService.listarTodos();
    }

    @GetMapping("/{id}")
    public PerfilDTO buscarPorId(@PathVariable Long id) {
        return perfilService.buscarPorId(id);
    }

    @PostMapping
    public void inserirPerfil(@RequestBody PerfilDTO perfilDTO) {
        perfilService.inserirPerfil(perfilDTO);
    }

    @PutMapping
    public PerfilDTO alterarPerfil(@RequestBody PerfilDTO perfilDTO) {
        return perfilService.alterarPerfil(perfilDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
        perfilService.deletarPerfil(id);
        return ResponseEntity.ok().build();
    }

}
