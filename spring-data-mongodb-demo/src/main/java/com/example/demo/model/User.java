package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class User {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private Date createdAt;
    private Date updatedAt;

}
