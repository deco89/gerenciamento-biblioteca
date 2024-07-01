package com.abfonseca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.UsuarioDTO;
import com.abfonseca.biblioteca.entity.UsuarioEntity;
import com.abfonseca.biblioteca.enums.TipoSituacaoUsuario;
import com.abfonseca.biblioteca.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }
    //usuario -> new UsuarioDTO(usuario)
    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado.")));        
    }    
    public void inserir(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));        
        usuarioRepository.save(usuarioEntity);
    }    
    public void inserirNovoUsario(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
        usuarioEntity.setId(null);
        usuarioRepository.save(usuarioEntity);

        emailService.enviarEmail(usuario.getEmail(), 
                        "Novo usuario cadastrado",
                        "Confirme sua identidade");
    }
    public UsuarioDTO atualizar(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void deletar(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
        usuarioRepository.delete(usuario);
    }
}
