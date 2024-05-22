package com.behl.cerberus.repository.Restaurant;

import com.behl.cerberus.entity.Restaurant.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity findByUuid(String uuid);

}
