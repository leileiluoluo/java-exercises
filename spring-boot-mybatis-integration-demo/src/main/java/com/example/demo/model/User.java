package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;
    private String email;
    private String name;
    private Role role;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Boolean deleted;

    public enum Role {
        ADMIN,
        EDITOR,
        VIEWER
    }
}
