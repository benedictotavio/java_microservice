package com.br.dog_control.dtos.dog;

import java.net.URL;

import com.br.dog_control.models.Owner;
import com.br.dog_control.utils.enums.Breed;

public class DogDtoRequest {

    private Owner owner;
    private String name;
    private int age;
    private Breed breed;
    private String color;
    private URL image;

    public DogDtoRequest(Owner owner, String name, int age, Breed breed, String color, URL image) {
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
        this.image = image;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

}
