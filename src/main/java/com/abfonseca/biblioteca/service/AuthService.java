package com.abfonseca.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.abfonseca.biblioteca.DTO.AccessDTO;
import com.abfonseca.biblioteca.DTO.AuthenticationDTO;
import com.abfonseca.biblioteca.security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;


    public AccessDTO login(AuthenticationDTO authDTO) {

        try {
        //Cria mecanismo de credencial para o spring
        UsernamePasswordAuthenticationToken userAuth = 
        new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

        //Prepara mecanismo para autenticacão
        Authentication authentication = authenticationManager.authenticate(userAuth);

        //Busca usuario logado
        UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

        String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

        AccessDTO accessDTO = new AccessDTO(token);

        return accessDTO;
        
        } catch (BadCredentialsException e) {
            //TODO login ou senha invalida
        }
        return new AccessDTO("Acesso negado");
    }
}
