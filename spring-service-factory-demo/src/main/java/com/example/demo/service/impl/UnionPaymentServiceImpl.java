package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.model.PaymentResult;
import com.example.demo.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("unionPaymentService")
public class UnionPaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResult pay(Order order) {
        return PaymentResult.builder()
                .success(true)
                .message("Union payment successful")
                .build();
    }

}
