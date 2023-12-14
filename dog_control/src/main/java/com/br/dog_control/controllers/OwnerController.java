package com.br.dog_control.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.dog_control.dtos.owner.OwnerDtoRequest;
import com.br.dog_control.dtos.owner.OwnerDtoResponse;
import com.br.dog_control.service.OwnerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/owner")
public class OwnerController {

    @Autowired
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<OwnerDtoResponse> newOwner(@Valid @RequestBody OwnerDtoRequest ownerDtoRequest) {
        OwnerDtoResponse ownerDtoResponse = ownerService.createNewOwner(ownerDtoRequest);
        return new ResponseEntity<OwnerDtoResponse>(ownerDtoResponse, HttpStatus.CREATED);
    }

}
