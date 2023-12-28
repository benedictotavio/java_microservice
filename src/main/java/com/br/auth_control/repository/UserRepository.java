package com.br.auth_control.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.auth_control.model.User;

public interface UserRepository extends MongoRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
