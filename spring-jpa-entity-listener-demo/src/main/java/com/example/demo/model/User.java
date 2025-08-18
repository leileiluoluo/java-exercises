package com.example.demo.model;

import com.example.demo.listener.OperationListener;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@EntityListeners(OperationListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date createdAt;
    private Date updatedAt;

}
