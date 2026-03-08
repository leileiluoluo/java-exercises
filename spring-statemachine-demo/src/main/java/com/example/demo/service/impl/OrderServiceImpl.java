package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private StateMachineService<OrderStates, OrderEvents> stateMachineService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(String name) {
        Date now = new Date();

        Order order = new Order();
        order.setName(name);
        order.setState(OrderStates.DRAFT);
        order.setCreatedAt(now);
        order.setUpdatedAt(now);

        // save
        order = orderRepository.save(order);

        // return
        return order;
    }

    @Override
    public void sendEvent(Long orderId, OrderEvents event) {
        StateMachine<OrderStates, OrderEvents> stateMachine = stateMachineService.acquireStateMachine(String.valueOf(orderId));

        OrderStates currentState = stateMachine.getState().getId();
        OrderStates state = orderRepository.getState(orderId);
        if (currentState != state) {
            restoreState(stateMachine, orderId, state);
        }

        Message<OrderEvents> message = MessageBuilder
                .withPayload(event)
                .setHeader("orderId", orderId)
                .build();

        stateMachine.sendEvent(message);
    }

    @Override
    public void updateState(Long orderId, OrderStates state) {
        orderRepository.updateState(orderId, state);
    }

    private void restoreState(StateMachine<OrderStates, OrderEvents> stateMachine, Long orderId, OrderStates state) {
        stateMachine.getStateMachineAccessor()
                .doWithAllRegions(access -> {
                    StateMachineContext<OrderStates, OrderEvents> context =
                            new DefaultStateMachineContext<>(
                                    state,
                                    null,
                                    null,
                                    null,
                                    null,
                                    String.valueOf(orderId)
                            );

                    access.resetStateMachine(context);
                });
    }

}
