package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends Repository<User, Long>, JpaSpecificationExecutor<User> {

    User findById(Long id);

    Page<User> findAll(Pageable pageable);

    boolean existsByNameAndEmail(String name, String email);

    List<User> findByNameIgnoreCase(String name);

    List<User> findByNameOrderByCreatedAtDesc(String name);

    User save(User user);

    long countByName(String name);

    void deleteById(Long id);

    @Query("select u from User u where u.name = :name and u.age = :age")
    User findByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    @Query("select u from User u where u.name = ?1 and u.age = ?2")
    User findByNameAndAgeAnotherWay(String name, Integer age);

    @Query(value = "select * from user where name = ?1 and age = ?2", nativeQuery = true)
    User findByNameAndAgeWithNativeSQL(String name, Integer age);

    @Transactional
    @Modifying
    @Query("update User u set u.name = :name where u.id = :id")
    void updateNameById(@Param("name") String name, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("delete from User u where u.age > :age")
    void deleteByAgeGreaterThan(@Param("age") Integer age);

    @Transactional
    @Procedure(name = "User.getMd5EmailById")
    String getMd5EmailUsingProcedure(@Param("user_id") Long id);

}
