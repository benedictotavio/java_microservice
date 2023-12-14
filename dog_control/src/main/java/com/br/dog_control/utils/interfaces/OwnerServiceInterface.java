package com.br.dog_control.utils.interfaces;

import java.util.Optional;

import com.br.dog_control.dtos.owner.OwnerDtoRequest;
import com.br.dog_control.dtos.owner.OwnerDtoResponse;
import com.br.dog_control.models.Owner;

public interface OwnerServiceInterface {
    OwnerDtoResponse createNewOwner(OwnerDtoRequest ownerDtoRequest);

    Optional<Owner> findOwnerByDocument(String document);
}
