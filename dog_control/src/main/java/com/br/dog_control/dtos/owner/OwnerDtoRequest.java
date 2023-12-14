package com.br.dog_control.dtos.owner;

public record OwnerDtoRequest(String name, String document, String email, boolean premium) {

    public String name() {
        return name;
    }

    public String document() {
        return document;
    }

    public String email() {
        return email;
    }

    public boolean premium() {
        return premium;
    }

}
