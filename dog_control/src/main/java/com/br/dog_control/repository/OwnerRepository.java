package com.br.dog_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.dog_control.models.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {
}
