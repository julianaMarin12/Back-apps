package com.pets.domain.repository;

import com.pets.domain.dto.PetDTO;
import java.util.List;
import java.util.Optional;

public interface PetRepository {
    List<PetDTO> getAllPets();
    Optional<PetDTO> getPetById(int petId);
    PetDTO savePet(PetDTO pet);
    void deletePet(int petId);
}