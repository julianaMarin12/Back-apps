package com.pets.persistence.crud;

import com.pets.persistence.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCrudRepository extends CrudRepository<ClientEntity, Integer> { }