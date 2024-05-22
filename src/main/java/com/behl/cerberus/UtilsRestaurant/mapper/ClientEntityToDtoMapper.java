

package com.behl.cerberus.UtilsRestaurant.mapper;

import com.behl.cerberus.dto.Restaurant.ClientDTO;
import com.behl.cerberus.entity.Restaurant.ClientEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientEntityToDtoMapper implements Converter<ClientEntity, ClientDTO> {
    @Override
    public ClientDTO convert(ClientEntity clientEntity) {
        return ClientDTO.builder()
                .name(clientEntity.getName())
                .document(clientEntity.getDocument())
                .email(clientEntity.getEmail())
                .phone(clientEntity.getPhone())
                .deliveryAddress(clientEntity.getDeliveryAddress())
                .build();
    }

    public ClientEntity convertDTO(ClientDTO clientDTO){
        return ClientEntity.builder()
                .name(clientDTO.getName())
                .document(clientDTO.getDocument())
                .email(clientDTO.getEmail())
                .phone(clientDTO.getPhone())
                .deliveryAddress(clientDTO.getDeliveryAddress())
                .build();
    }
}