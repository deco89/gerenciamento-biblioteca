package com.abfonseca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.PerfilUsuarioDTO;
import com.abfonseca.biblioteca.entity.PerfilUsuarioEntity;
import com.abfonseca.biblioteca.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;
    
    public List<PerfilUsuarioDTO> listarTodos() {
        List<PerfilUsuarioEntity> perfilUsuario = perfilUsuarioRepository.findAll();
        return perfilUsuario.stream().map(PerfilUsuarioDTO::new).toList();
    }

    public PerfilUsuarioDTO buscarPorId(Long id) {
        return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado.")));
    }

    public void inserirPerfil(PerfilUsuarioDTO perfilUsuario) {
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
        perfilUsuarioRepository.save(perfilUsuarioEntity);
    }

    public PerfilUsuarioDTO alterarPerfil(PerfilUsuarioDTO perfilUsuarioDTO) {
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuarioDTO);
        return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
    } 

    public void deletarPerfil(Long id) {
        PerfilUsuarioEntity perfilUsuarioEntity = perfilUsuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        perfilUsuarioRepository.delete(perfilUsuarioEntity);
    }
}
