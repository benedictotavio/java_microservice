package com.br.dog_control.service;

import org.springframework.stereotype.Service;

import com.br.dog_control.dtos.dog.DogDtoRequest;
import com.br.dog_control.models.Dog;
import com.br.dog_control.repository.DogRepository;

@Service
public class DogService {
    private DogRepository dogRepository;

    public DogDtoRequest saveDog(DogDtoRequest dogDtoRequest) {
        Dog dog = new Dog();
        dog.setAge(dogDtoRequest.getAge());
        dog.setOwner(dogDtoRequest.getOwner());
        dog.setName(dogDtoRequest.getName());
        dog.setBreed(dogDtoRequest.getBreed());
        dog.setColor(dogDtoRequest.getColor());
        dog.setImage(dogDtoRequest.getImage());

        Dog savedDog = dogRepository.save(dog);
        return new DogDtoRequest(savedDog.getOwner(), savedDog.getName(), savedDog.getAge(), savedDog.getBreed(),
                savedDog.getColor(), savedDog.getImage());

    }

}
