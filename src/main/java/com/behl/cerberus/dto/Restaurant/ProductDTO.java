package com.behl.cerberus.dto.Restaurant;


import com.behl.cerberus.entity.Restaurant.ProductEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private String uuid;
    private String fantasyName;
    private ProductEntity.Category category;
    private String description;
    private Double price;
    private Boolean available;
}
