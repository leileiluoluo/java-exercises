package com.example.demo.config;

import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;

@Configuration
public class OrderStateMachineServiceConfig extends StateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    @Bean
    public StateMachineService<OrderStates, OrderEvents> stateMachineService(
            StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory) {
        return new DefaultStateMachineService<>(stateMachineFactory);
    }

}
