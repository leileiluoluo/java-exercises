package com.example.demo.service.impl;

import com.example.demo.model.UserRegisteredEvent;
import com.example.demo.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouponServiceImpl.class);

    @Async
    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        // issue coupon
        LOGGER.info("coupon successfully issued to: {}", event.getEmail());
    }

}
