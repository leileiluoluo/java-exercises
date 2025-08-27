package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String username;
    private Integer age;
    private Boolean newCenturyUser;
    private String role;
    private LocalDateTime createdDate;

}
