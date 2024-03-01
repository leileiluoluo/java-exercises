package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUserByAgeGreaterThanWithException(Integer age) {
        userRepository.deleteByAgeGreaterThan(age);

        throw new RuntimeException("transaction test");
    }

}
