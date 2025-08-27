package com.example.demo.service.impl;

import com.example.demo.model.UserRegisteredEvent;
import com.example.demo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Async
    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        // send email
        LOGGER.info("email successfully sent to: {}", event.getEmail());
    }

}
