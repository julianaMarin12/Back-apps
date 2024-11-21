package com.pets.domain.mapper;

import com.pets.domain.dto.ClientDTO;
import com.pets.persistence.entity.ClientEntity;
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
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO toClient(ClientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String address = null;
        String email = null;
        Integer id = null;
        String name = null;
        String phoneNumber = null;

        address = entity.getAddress();
        email = entity.getEmail();
        id = entity.getId();
        name = entity.getName();
        phoneNumber = entity.getPhoneNumber();

        ClientDTO clientDTO = new ClientDTO( id, name, email, phoneNumber, address );

        return clientDTO;
    }

    @Override
    public ClientEntity toEntity(ClientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setAddress( dto.getAddress() );
        clientEntity.setEmail( dto.getEmail() );
        clientEntity.setId( dto.getId() );
        clientEntity.setName( dto.getName() );

        return clientEntity;
    }

    @Override
    public List<ClientDTO> toClients(List<ClientEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( entities.size() );
        for ( ClientEntity clientEntity : entities ) {
            list.add( toClient( clientEntity ) );
        }

        return list;
    }
}
