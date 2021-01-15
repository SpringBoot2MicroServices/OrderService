package com.ar.javatech.os.api.controller;

import com.ar.javatech.os.api.dto.TransactionRequest;
import com.ar.javatech.os.api.dto.TransactionResponse;
import com.ar.javatech.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin("/*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/book-order")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        return orderService.placeOrder(request);
    }
}
