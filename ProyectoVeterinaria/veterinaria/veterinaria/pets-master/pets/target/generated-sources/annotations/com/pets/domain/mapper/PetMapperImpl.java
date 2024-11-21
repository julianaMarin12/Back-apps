package com.pets.domain.mapper;

import com.pets.domain.dto.PetDTO;
import com.pets.persistence.entity.ClientEntity;
import com.pets.persistence.entity.PetEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-21T10:51:54-0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public PetDTO toPet(PetEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Integer ownerId = null;
        Integer age = null;
        String gender = null;
        Integer id = null;
        String medicalHistoryLink = null;
        String name = null;
        String species = null;
        Double weight = null;

        ownerId = entityOwnerId( entity );
        age = entity.getAge();
        gender = entity.getGender();
        id = entity.getId();
        medicalHistoryLink = entity.getMedicalHistoryLink();
        name = entity.getName();
        species = entity.getSpecies();
        weight = entity.getWeight();

        PetDTO petDTO = new PetDTO( id, name, ownerId, species, gender, age, weight, medicalHistoryLink );

        return petDTO;
    }

    @Override
    public PetEntity toEntity(PetDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PetEntity petEntity = new PetEntity();

        petEntity.setOwner( petDTOToClientEntity( dto ) );
        petEntity.setAge( dto.getAge() );
        petEntity.setGender( dto.getGender() );
        petEntity.setId( dto.getId() );
        petEntity.setMedicalHistoryLink( dto.getMedicalHistoryLink() );
        petEntity.setName( dto.getName() );
        petEntity.setSpecies( dto.getSpecies() );
        petEntity.setWeight( dto.getWeight() );

        return petEntity;
    }

    @Override
    public List<PetDTO> toPets(List<PetEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PetDTO> list = new ArrayList<PetDTO>( entities.size() );
        for ( PetEntity petEntity : entities ) {
            list.add( toPet( petEntity ) );
        }

        return list;
    }

    private Integer entityOwnerId(PetEntity petEntity) {
        ClientEntity owner = petEntity.getOwner();
        if ( owner == null ) {
            return null;
        }
        return owner.getId();
    }

    protected ClientEntity petDTOToClientEntity(PetDTO petDTO) {
        if ( petDTO == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( petDTO.getOwnerId() );

        return clientEntity;
    }
}
