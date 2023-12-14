package com.br.dog_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.dog_control.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, String> {}
