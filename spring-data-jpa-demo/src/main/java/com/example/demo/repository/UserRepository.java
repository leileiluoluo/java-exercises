package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {

    User findById(Long id);

    Page<User> findAll(Pageable pageable);

    List<User> findByNameIgnoreCase(String name);

    List<User> findByNameOrderByCreatedAtDesc(String name);

}
