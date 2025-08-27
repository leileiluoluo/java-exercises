package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String email;
    private String username;
    private Date registeredAt;

}
