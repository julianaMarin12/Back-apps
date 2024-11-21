package com.pets.persistence;

import com.pets.domain.dto.PetDTO;
import com.pets.domain.repository.PetRepository;
import com.pets.persistence.crud.PetCrudRepository;
import com.pets.persistence.entity.PetEntity;
import com.pets.domain.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PetRepositoryImpl implements PetRepository {
    @Autowired
    private PetCrudRepository petCrudRepository;

    @Autowired
    private PetMapper petMapper;

    @Override
    public List<PetDTO> getAllPets() {
        List<PetEntity> pets = (List<PetEntity>) petCrudRepository.findAll();
        return petMapper.toPets(pets);
    }

    @Override
    public Optional<PetDTO> getPetById(int petId) {
        return petCrudRepository.findById(petId).map(petMapper::toPet);
    }

    @Override
    public PetDTO savePet(PetDTO petDTO) {
        PetEntity petEntity = petMapper.toEntity(petDTO);
        return petMapper.toPet(petCrudRepository.save(petEntity));
    }

    @Override
    public void deletePet(int petId) {
        petCrudRepository.deleteById(petId);
    }
}