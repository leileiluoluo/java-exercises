package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document("users")
public class User {

    @Id
    private String id;
    private String email;
    private String name;
    private Role role;
    private String description;
    @Field("created_at")
    private Date createdAt;
    @Field("updated_at")
    private Date updatedAt;
    private Boolean deleted;

    public enum Role {
        ADMIN,
        EDITOR,
        VIEWER
    }
}
