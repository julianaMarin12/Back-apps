package com.pets.domain.mapper;

import com.pets.domain.dto.PetDTO;
import com.pets.persistence.entity.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "ownerId", source = "owner.id")
    PetDTO toPet(PetEntity entity);

    @Mapping(target = "owner.id", source = "ownerId")
    PetEntity toEntity(PetDTO dto);

    List<PetDTO> toPets(List<PetEntity> entities);
}