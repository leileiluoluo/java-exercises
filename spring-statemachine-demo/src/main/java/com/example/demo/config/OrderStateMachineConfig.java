package com.example.demo.config;

import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class OrderStateMachineConfig
        extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderStates, OrderEvents> config)
            throws Exception {
        config.withConfiguration()
                .autoStartup(true);
    }

    @Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states)
            throws Exception {
        states.withStates()
                .initial(OrderStates.DRAFT)
                .states(EnumSet.allOf(OrderStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions)
            throws Exception {
        transitions.withExternal()
                .source(OrderStates.DRAFT).target(OrderStates.CREATED).event(OrderEvents.CREATE)
                .and()
                .withExternal()
                .source(OrderStates.CREATED).target(OrderStates.PAID).event(OrderEvents.PAY)
                .and()
                .withExternal()
                .source(OrderStates.PAID).target(OrderStates.SHIPPED).event(OrderEvents.SHIP)
                .and()
                .withExternal()
                .source(OrderStates.SHIPPED).target(OrderStates.DELIVERED).event(OrderEvents.DELIVER);
    }

}
