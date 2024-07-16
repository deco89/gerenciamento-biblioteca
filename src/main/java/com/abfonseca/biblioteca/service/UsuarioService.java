package com.abfonseca.biblioteca.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.UsuarioDTO;
import com.abfonseca.biblioteca.entity.UsuarioEntity;
import com.abfonseca.biblioteca.entity.UsuarioVerificadorEntity;
import com.abfonseca.biblioteca.enums.TipoSituacaoUsuario;
import com.abfonseca.biblioteca.repository.UsuarioRepository;
import com.abfonseca.biblioteca.repository.UsuarioVerificadorRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioVerificadorRepository usuarioVerificadorRepository;

    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }
    //usuario -> new UsuarioDTO(usuario)
    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado.")));        
    }    
    // public void inserir(UsuarioDTO usuario) {
    //     UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
    //     usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));        
    //     usuarioRepository.save(usuarioEntity);
    // }    
    public void inserirNovoUsuario(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
        usuarioEntity.setId(null);
        usuarioRepository.save(usuarioEntity);

        UsuarioVerificadorEntity verificador = new UsuarioVerificadorEntity();
        verificador.setUsuario(usuarioEntity);
        verificador.setUuid(UUID.randomUUID());
        verificador.setDataExpiracao(Instant.now().plusSeconds(900));
        usuarioVerificadorRepository.save(verificador);


        emailService.enviarEmail(usuario.getEmail(), 
                        "Validação de Cadastro",
                        "Você está recebendo um email de cadastro. O número para validação é: " + verificador.getUuid());
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não econtrado"));

        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setLogin(usuario.getLogin());

        if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }
        
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void deletar(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
        usuarioRepository.delete(usuario);
    }

    public String checarCadastro(String uuid) {
        UsuarioVerificadorEntity usuarioVerificador = usuarioVerificadorRepository.findByUuid(UUID.fromString(uuid)).get();

        if(usuarioVerificador != null) { 
            if (usuarioVerificador.getDataExpiracao().compareTo(Instant.now()) >= 0) {
                UsuarioEntity usuario = usuarioVerificador.getUsuario();
                usuario.setSituacao(TipoSituacaoUsuario.ATIVO);
                usuarioRepository.save(usuario);

                return "Verificação concluida";
            } else {
                usuarioVerificadorRepository.delete(usuarioVerificador);
                return "Tempo expirado. Por favor repita o procedimento";
            } 
        }else {
                return "Usuario não verificado";
        }
    }
}
