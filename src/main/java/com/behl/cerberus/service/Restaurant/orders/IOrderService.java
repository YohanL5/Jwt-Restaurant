package com.behl.cerberus.service.Restaurant.orders;

import com.behl.cerberus.dto.Restaurant.OrderDTO;

import java.time.LocalDateTime;

public interface IOrderService {


    OrderDTO createOrder(OrderDTO orderDTO );

    OrderDTO updateOrderDelivered(String  uuid, LocalDateTime timeStamp);

}