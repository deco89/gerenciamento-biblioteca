package com.abfonseca.biblioteca.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccessDTO {

    private String token;

    public AccessDTO(String token) {
        this.token = token;
    }

    //TODO implementar retornar usuario e liberações (authorities)

    



}
