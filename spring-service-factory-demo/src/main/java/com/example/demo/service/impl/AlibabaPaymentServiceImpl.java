package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.model.PaymentResult;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("alibabaPaymentService")
public class AlibabaPaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResult pay(Order order) {
        return PaymentResult.builder()
                .success(true)
                .message("Alibaba payment successful")
                .build();
    }

}
