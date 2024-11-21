package com.pets.domain.service;

import com.pets.domain.dto.ClientDTO;
import com.pets.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAllClients() {
        return clientRepository.getAllClients();
    }

    public Optional<ClientDTO> getClientById(int clientId) {
        Optional<ClientDTO> client = clientRepository.getClientById(clientId);
        if (client.isEmpty()) {
            throw new IllegalArgumentException("client not found");
        }
        return client;
    }

    public ClientDTO saveClient(ClientDTO client) {
        return clientRepository.saveClient(client);
    }

    public boolean deleteClient(int clientId) {
        Optional<ClientDTO> client = getClientById(clientId);
        if (client.isPresent()) {
            clientRepository.deleteClient(clientId);
            return true;
        } else {
            throw new IllegalArgumentException("client not found");
        }
    }
}