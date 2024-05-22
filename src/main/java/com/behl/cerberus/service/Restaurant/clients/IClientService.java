package com.behl.cerberus.service.Restaurant.clients;

import com.behl.cerberus.dto.Restaurant.ClientDTO;

import java.util.List;

public interface IClientService {
    List<ClientDTO> getClients();

    ClientDTO getClient(String document);
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(String document, ClientDTO clientDTO);
    void deleteClient(String  document);
}

