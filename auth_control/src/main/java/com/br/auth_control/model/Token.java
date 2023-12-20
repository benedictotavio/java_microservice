package com.br.auth_control.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.br.auth_control.enums.TokenType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("token")
public class Token {

    @Id
    public Integer id;

    public String token;

    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    public User user;
}
