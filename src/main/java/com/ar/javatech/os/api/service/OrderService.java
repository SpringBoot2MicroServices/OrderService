package com.ar.javatech.os.api.service;

import com.ar.javatech.os.api.entity.Order;
import com.ar.javatech.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order){
        return orderRepository.save(order);
    }
}
