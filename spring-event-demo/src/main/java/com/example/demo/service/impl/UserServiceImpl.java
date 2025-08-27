package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.UserRegisteredEvent;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void save(User user) {
        // save user
        // userRepository.save(user);

        // publish event
        UserRegisteredEvent event = UserRegisteredEvent.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
        eventPublisher.publishEvent(event);
        LOGGER.info("user registered event successfully published");
    }

}
