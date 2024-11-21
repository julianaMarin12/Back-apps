package com.pets.domain.repository;

import com.pets.domain.dto.ClientDTO;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<ClientDTO> getAllClients();
    Optional<ClientDTO> getClientById(int clientId);
    ClientDTO saveClient(ClientDTO client);
    void deleteClient(int clientId);
}