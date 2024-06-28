package com.abfonseca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.PerfilDTO;
import com.abfonseca.biblioteca.entity.PerfilEntity;
import com.abfonseca.biblioteca.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilDTO> listarTodos() {
        List<PerfilEntity> perfil = perfilRepository.findAll();
        return perfil.stream().map(PerfilDTO::new).toList();
    }

    public PerfilDTO buscarPorId(Long id) {
        return new PerfilDTO(perfilRepository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado.")));        
    }

    public void inserirPerfil(PerfilDTO perfilDTO) {
        PerfilEntity perfilEntity = new PerfilEntity(perfilDTO);
        perfilRepository.save(perfilEntity);
    }

    public PerfilDTO alterarPerfil(PerfilDTO perfilDTO) {
        PerfilEntity perfilEntity = new PerfilEntity(perfilDTO);
        return new PerfilDTO(perfilRepository.save(perfilEntity));
    }

    public void deletarPerfil(Long id) {
        PerfilEntity perfilEntity = perfilRepository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado."));
        perfilRepository.delete(perfilEntity);
    }

}
