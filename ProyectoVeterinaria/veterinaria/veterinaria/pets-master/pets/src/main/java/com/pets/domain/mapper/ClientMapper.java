package com.pets.domain.mapper;

import com.pets.domain.dto.ClientDTO;
import com.pets.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toClient(ClientEntity entity);
    ClientEntity toEntity(ClientDTO dto);
    List<ClientDTO> toClients(List<ClientEntity> entities);
}