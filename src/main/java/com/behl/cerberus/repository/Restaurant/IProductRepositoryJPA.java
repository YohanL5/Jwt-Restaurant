package com.behl.cerberus.repository.Restaurant;

import com.behl.cerberus.entity.Restaurant.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepositoryJPA extends JpaRepository<ProductEntity,Long> {

    ProductEntity findByUuid(String uuid);
    Boolean existsByfantasyName(String fantasyName);

}
