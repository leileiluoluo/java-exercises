package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.PaymentResult;

public interface PaymentService {

    PaymentResult pay(Order order);

}
