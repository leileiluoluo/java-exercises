package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;
    private String email;
    private String name;
    private Integer yearOfBirth;
    private Role role;
    private Date createdAt;

}
