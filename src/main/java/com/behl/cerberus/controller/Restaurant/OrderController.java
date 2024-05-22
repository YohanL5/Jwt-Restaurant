package com.behl.cerberus.controller.Restaurant;

import com.behl.cerberus.dto.Restaurant.OrderDTO;
import com.behl.cerberus.service.Restaurant.orders.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/orders")

public class OrderController {

    @Autowired
    OrderServiceImpl service;

    @PostMapping("/newOrders")
    @PreAuthorize("hasAuthority('fullaccess')")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<>(service.createOrder(orderDTO) , HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{uuid}/delivered/{timestamp}")
    @PreAuthorize("hasAuthority('fullaccessAdmin')")
    public ResponseEntity<?> updateOrderDelivered(@PathVariable String uuid, @PathVariable LocalDateTime timestamp){
        return new ResponseEntity<>(service.updateOrderDelivered(uuid, timestamp), HttpStatus.OK);
    }
}
