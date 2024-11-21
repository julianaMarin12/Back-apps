package com.pets.persistence.crud;

import com.pets.persistence.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCrudRepository extends CrudRepository<PetEntity, Integer> { }