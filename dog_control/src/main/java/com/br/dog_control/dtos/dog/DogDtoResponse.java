package com.br.dog_control.dtos.dog;

import com.br.dog_control.utils.enums.Breed;

public class DogDtoResponse {

    private String name;
    private int age;
    private Breed breed;
    private String color;
    
    public DogDtoResponse(String name, int age, Breed breed, String color) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

}
