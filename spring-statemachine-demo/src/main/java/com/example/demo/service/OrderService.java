package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;

public interface OrderService {

    Order createOrder(String name);

    void sendEvent(Long orderId, OrderEvents event);

    void updateState(Long orderId, OrderStates state);

}
