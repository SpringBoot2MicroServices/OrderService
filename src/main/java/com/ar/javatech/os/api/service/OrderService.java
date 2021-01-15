package com.ar.javatech.os.api.service;

import com.ar.javatech.os.api.dto.Payment;
import com.ar.javatech.os.api.dto.TransactionRequest;
import com.ar.javatech.os.api.dto.TransactionResponse;
import com.ar.javatech.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse placeOrder(TransactionRequest txRequest){

        String responseMessage = "";

        txRequest.getPayment().setOrderId(txRequest.getOrder().getOrderId());
        txRequest.getPayment().setAmount(txRequest.getOrder().getPrice());

        // REST - CALL
        Payment response = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/initiate-payment", txRequest.getPayment(), Payment.class);

        responseMessage = response.getPaymentStatus().equals("success")?"Payment processed successfully! Order placed":
                                                             "Payment process failed, order added to cart";
        orderRepository.save(txRequest.getOrder());

        return new TransactionResponse(txRequest.getOrder(), response.getAmount(),
                   response.getTransactionId(), responseMessage);
    }
}
