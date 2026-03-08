package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.enums.OrderEvents;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        // order-1
        Order order1 = orderService.createOrder("order-1");
        Long orderId1 = order1.getId();
        orderService.sendEvent(orderId1, OrderEvents.CREATE);
        orderService.sendEvent(orderId1, OrderEvents.PAY);
        orderService.sendEvent(orderId1, OrderEvents.SHIP);
        orderService.sendEvent(orderId1, OrderEvents.DELIVER);

        // order-2
        Order order2 = orderService.createOrder("order-2");
        Long orderId2 = order2.getId();
        orderService.sendEvent(orderId2, OrderEvents.CREATE);
    }

}
