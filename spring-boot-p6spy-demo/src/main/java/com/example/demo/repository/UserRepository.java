package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByNameAndEmail(String name, String email);

    List<User> findByNameIgnoreCase(String name);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.email = :email")
    void updateNameByEmail(@Param("name") String name, @Param("email") String email);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user WHERE email = :email", nativeQuery = true)
    void deleteByEmail(@Param("email") String email);

}
