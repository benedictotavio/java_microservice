package com.br.dog_control.dtos.dog;

import com.br.dog_control.utils.enums.Breed;

public record DogDtoRequest(String ownerId, String name, int age, Breed breed, String color, String image) {

    public String ownerId() {
        return ownerId;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public Breed breed() {
        return breed;
    }

    public String color() {
        return color;
    }

    public String image() {
        return image;
    }

}
