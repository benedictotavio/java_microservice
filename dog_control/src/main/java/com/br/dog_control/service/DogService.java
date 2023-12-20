package com.br.dog_control.service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.dog_control.dtos.dog.DogDtoRequest;
import com.br.dog_control.dtos.dog.DogDtoResponse;
import com.br.dog_control.models.Dog;
import com.br.dog_control.models.Owner;
import com.br.dog_control.repository.DogRepository;
import com.br.dog_control.repository.OwnerRepository;
import com.br.dog_control.utils.interfaces.DogServiceInterface;

@Service
public class DogService implements DogServiceInterface {

    private final DogRepository dogRepository;
    private final OwnerRepository ownerRepository;

    public DogService(DogRepository dogRepository, OwnerRepository ownerRepository) {
        this.dogRepository = dogRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public DogDtoResponse saveDog(DogDtoRequest dogDtoRequest) throws MalformedURLException, URISyntaxException {
        Owner owner = ownerRepository.findById(dogDtoRequest.ownerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
                
        Dog dog = new Dog();
        dog.setAge(dogDtoRequest.age());
        dog.setBreed(dogDtoRequest.breed());
        dog.setColor(dogDtoRequest.color());
        dog.setImage(createDogUrlImage(dogDtoRequest.image()));
        dog.setName(dogDtoRequest.name());
        dog.setOwner(owner);

        Dog newDog = dogRepository.save(dog);

        return new DogDtoResponse(newDog.getName(), newDog.getAge(), newDog.getBreed(), newDog.getColor());
    }

    @Override
    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Optional<Dog> findDogById(Long id) {
        return dogRepository.findById(id);
    }

    private URL createDogUrlImage(String urlImage) throws MalformedURLException, URISyntaxException {
        return new URI(urlImage).toURL();
    }

}
