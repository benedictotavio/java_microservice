package com.br.auth_control.dtos;

public record RegisteredUserDto(String document, String name, String email, boolean premium) {

    public String document() {
        return document;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public boolean premium() {
        return premium;
    }

}