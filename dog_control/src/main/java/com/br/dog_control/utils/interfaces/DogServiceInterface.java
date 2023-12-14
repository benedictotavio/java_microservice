package com.br.dog_control.utils.interfaces;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.br.dog_control.dtos.dog.DogDtoRequest;
import com.br.dog_control.dtos.dog.DogDtoResponse;
import com.br.dog_control.models.Dog;

public interface DogServiceInterface {
    DogDtoResponse saveDog(DogDtoRequest dogDtoRequest) throws MalformedURLException, URISyntaxException;

    List<Dog> findAllDogs();

    Optional<Dog> findDogById(Long id);
}