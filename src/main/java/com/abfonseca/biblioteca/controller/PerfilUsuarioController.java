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

import com.abfonseca.biblioteca.DTO.PerfilUsuarioDTO;
import com.abfonseca.biblioteca.service.PerfilUsuarioService;

@RestController
@RequestMapping(value = "/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public List<PerfilUsuarioDTO> listarTodos() {
        return perfilUsuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public PerfilUsuarioDTO buscarPorId(@PathVariable Long id) {
        return perfilUsuarioService.buscarPorId(id);
    }

    @PostMapping
    public void inserirPerfil(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
        perfilUsuarioService.inserirPerfil(perfilUsuarioDTO);
    }

    @PutMapping
    public PerfilUsuarioDTO alterarPerfil(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
        return perfilUsuarioService.alterarPerfil(perfilUsuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
        perfilUsuarioService.deletarPerfil(id);
        return ResponseEntity.ok().build();
    }

}
