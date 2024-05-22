
package com.behl.cerberus.service.Restaurant.clients;

import com.behl.cerberus.UtilsRestaurant.exception.impl.ClientNotFoundException;
import com.behl.cerberus.UtilsRestaurant.mapper.ClientEntityToDtoMapper;
import com.behl.cerberus.UtilsRestaurant.validator.ClientValidator;
import com.behl.cerberus.dto.Restaurant.ClientDTO;
import com.behl.cerberus.entity.Restaurant.ClientEntity;
import com.behl.cerberus.entity.UserStatus;
import com.behl.cerberus.repository.Restaurant.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService  implements IClientService {

    private final ClientValidator clientValidator;
    private final ClientRepository clientRepository;
    private final ClientEntityToDtoMapper mapper;

    @Autowired
    public ClientService(ClientValidator clientValidator, ClientRepository clientRepository, ClientEntityToDtoMapper mapper) {
        this.clientValidator = clientValidator;
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ClientDTO> getClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        return clients.stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(String document) {
        clientValidator.validateDocumentFormat(document);
        ClientEntity clientEntity = clientRepository.findByDocument(document);
        if (clientEntity == null) {
            throw new ClientNotFoundException("No existe cliente con el número de documento suministrado");
        }
        return mapper.convert(clientEntity);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        clientValidator.validateCliente(clientDTO);
        clientValidator.validateDocumentFormat(clientDTO.getDocument());
        ClientEntity clientEntity = mapper.convertDTO(clientDTO);
        clientRepository.save(clientEntity);
        return mapper.convert(clientEntity);
    }

    public  ClientDTO updateClient(String document, ClientDTO clientDTO) {
        clientValidator.validateCliente(clientDTO);
        clientValidator.validateDocumentFormat(clientDTO.getDocument());
        ClientEntity clientEntity = clientRepository.findByDocument(document);

        if (clientEntity == null) {
            throw new ClientNotFoundException("No se encontró ningún cliente con el documento proporcionado");
        }

        // Verificar si existe otro cliente con el mismo documento diferente al que se está editando
        ClientEntity existingClient = clientRepository.findByDocument(document);

        clientValidator.validateCliente(clientDTO);
        clientValidator.clientCompare(clientDTO, mapper.convert(existingClient));

        if (clientRepository.existsByDocument(clientDTO.getDocument()) && clientValidator.clientExistByDocument(existingClient.getDocument(), clientDTO.getDocument())){
            throw new ClientNotFoundException("Cliente con" + clientDTO.getDocument() + "no existe");
        }
        //clientEntity.setId(clientDTO.getId());
        clientEntity.setName(clientDTO.getName());
        clientEntity.setDocument(clientDTO.getDocument());
        clientEntity.setEmail(clientDTO.getEmail());
        clientEntity.setPhone(clientDTO.getPhone());
        clientEntity.setDeliveryAddress(clientDTO.getDeliveryAddress());
        clientRepository.save(clientEntity);
        return mapper.convert(clientEntity);
    }


    @Override
    public void deleteClient(String document) {
        clientValidator.validateDocumentFormat(document);
        ClientEntity clientEntity = clientRepository.findByDocument(document);
        if (clientEntity == null) {
            throw new ClientNotFoundException("No se encontró ningún cliente con el documento proporcionado");
        }
        clientRepository.deleteByDocument(document);
    }

}