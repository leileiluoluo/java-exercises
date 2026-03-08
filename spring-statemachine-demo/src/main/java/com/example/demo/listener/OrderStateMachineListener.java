package com.example.demo.listener;

import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

@Component
@WithStateMachine
public class OrderStateMachineListener {

    @Autowired
    private OrderService orderService;

    @OnStateChanged
    public void onStateChange(StateContext<OrderStates, OrderEvents> context) {
        Message<OrderEvents> message = context.getMessage();

        if (null != message) {
            Long orderId = message.getHeaders().get("orderId", Long.class);
            OrderStates targetState = context.getTarget().getId();

            // update state
            orderService.updateState(orderId, targetState);
        }
    }

}