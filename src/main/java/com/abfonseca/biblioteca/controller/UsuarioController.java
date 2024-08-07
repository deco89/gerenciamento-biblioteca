package com.abfonseca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abfonseca.biblioteca.DTO.UsuarioDTO;
import com.abfonseca.biblioteca.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin //Método generalista para evitar problema de CORS que permite acessos estranhos no http.
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void inserir(@RequestBody UsuarioDTO usuario) {
        usuarioService.inserirNovoUsuario(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioDTO alterar(@PathVariable Long id, @RequestBody UsuarioDTO usuario) {
        return usuarioService.atualizar(id, usuario);
    }

    //localhost:8080/usuario/3
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.ok().build();
    }
    
}
