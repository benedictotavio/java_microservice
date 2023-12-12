package com.br.dog_control.utils.enums;

public enum Breed {
    LABRADOR_RETRIEVER("Labrador Retriever"),
    GERMAN_SHEPHERD("German Shepherd"),
    GOLDEN_RETRIEVER("Golden Retriever"),
    BEAGLE("Beagle"),
    POODLE("Poodle"),
    BULLDOG("Bulldog"),
    DACHSHUND("Dachshund"),
    BOXER("Boxer"),
    CHIHUAHUA("Chihuahua"),
    SIBERIAN_HUSKY("Siberian Husky");

    private final String breedName;

    Breed(String breedName) {
        this.breedName = breedName;
    }

    public String getBreedName() {
        return breedName;
    }
}

