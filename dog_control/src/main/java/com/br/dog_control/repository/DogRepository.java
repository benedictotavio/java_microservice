package com.br.dog_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.dog_control.models.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {}
