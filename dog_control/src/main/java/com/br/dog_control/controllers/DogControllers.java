package com.br.dog_control.controllers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.dog_control.dtos.dog.DogDtoRequest;
import com.br.dog_control.dtos.dog.DogDtoResponse;
import com.br.dog_control.models.Dog;
import com.br.dog_control.service.DogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/dog")
public class DogControllers {

    private final DogService dogService;

    public DogControllers(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping()
    @ResponseBody
    public List<Dog> getAllDogs() {
        return dogService.findAllDogs();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Dog> getDogByInd(@PathVariable("id") Long id) {
        return dogService.findDogById(id);
    }

    // Create new user
    @PostMapping
    @ResponseBody
    public ResponseEntity<DogDtoResponse> createNewDog(@Valid @RequestBody DogDtoRequest dogDtoRequest)
            throws MalformedURLException, URISyntaxException {
        DogDtoResponse dogDtoResponse = dogService.saveDog(dogDtoRequest);
        return ResponseEntity.ok(dogDtoResponse);
    }
}
