package com.pets.persistence;

import com.pets.domain.dto.ClientDTO;
import com.pets.domain.repository.ClientRepository;
import com.pets.persistence.crud.ClientCrudRepository;
import com.pets.persistence.entity.ClientEntity;
import com.pets.domain.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getAllClients() {
        List<ClientEntity> clients = (List<ClientEntity>) clientCrudRepository.findAll();
        return clientMapper.toClients(clients);
    }

    @Override
    public Optional<ClientDTO> getClientById(int clientId) {
        return clientCrudRepository.findById(clientId).map(clientMapper::toClient);
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientMapper.toEntity(clientDTO);
        return clientMapper.toClient(clientCrudRepository.save(clientEntity));
    }

    @Override
    public void deleteClient(int clientId) {
        clientCrudRepository.deleteById(clientId);
    }
}