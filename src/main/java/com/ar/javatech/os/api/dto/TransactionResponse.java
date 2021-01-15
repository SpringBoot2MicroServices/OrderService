package com.ar.javatech.os.api.dto;

import com.ar.javatech.os.api.entity.Order;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;
    private double amount;
    private String transactionId;
    private String responseMessage;
}
