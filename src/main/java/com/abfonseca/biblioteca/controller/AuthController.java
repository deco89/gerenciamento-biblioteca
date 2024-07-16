package com.abfonseca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abfonseca.biblioteca.DTO.AuthenticationDTO;
import com.abfonseca.biblioteca.DTO.UsuarioDTO;
import com.abfonseca.biblioteca.service.AuthService;
import com.abfonseca.biblioteca.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService; // Assuming AuthService is already defined and injected via dependency injection.

    @Autowired 
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO) {
        return ResponseEntity.ok(authService.login(authDTO));
    }

    @PostMapping(value = "/novoUsuario")
    public void inserirNovoUsuario(@RequestBody UsuarioDTO usuario) {
        usuarioService.inserirNovoUsuario(usuario);
    }

    @GetMapping(value = "/checarCadastro/{uuid}")
    public String checarCadastro(@PathVariable String uuid) {
        return usuarioService.checarCadastro(uuid);
    }


}
