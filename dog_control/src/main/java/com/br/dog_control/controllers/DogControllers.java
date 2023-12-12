package com.br.dog_control.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.dog_control.dtos.dog.DogDtoRequest;
import com.br.dog_control.service.DogService;

@RestController
@RequestMapping("/api/v1")
public class DogControllers {
    @Autowired
    private DogService dogService;

    // Create new user
    @PostMapping("/dog")
    public ResponseEntity<DogDtoRequest> postMethodName(@RequestBody DogDtoRequest dogDtoRequest) {
        return new ResponseEntity<>(dogService.saveDog(dogDtoRequest), HttpStatus.OK);
    }

}
