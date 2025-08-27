package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegisteredEvent {

    private String email;
    private String username;

}
