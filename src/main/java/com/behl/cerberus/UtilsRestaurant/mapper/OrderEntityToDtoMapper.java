package com.behl.cerberus.UtilsRestaurant.mapper;

import com.behl.cerberus.dto.Restaurant.OrderDTO;
import com.behl.cerberus.entity.Restaurant.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityToDtoMapper {

    public OrderDTO convert(OrderEntity orderEntity) {
        return OrderDTO.builder()
                .uuid(orderEntity.getUuid())
                .creationDateTime(orderEntity.getCreationDateTime())
                .clientDocument(orderEntity.getClientDocument())
                .productUuid(orderEntity.getProductUuid())
                .quantity(orderEntity.getQuantity())
                .extraInformation(orderEntity.getExtraInformation())
                .subTotal(orderEntity.getSubTotal())
                .tax(orderEntity.getTax())
                .grandTotal(orderEntity.getGrandTotal())
                .delivered(orderEntity.getDelivered())
                .deliveredDate(orderEntity.getDeliveredDate())
                .build();
    }


}