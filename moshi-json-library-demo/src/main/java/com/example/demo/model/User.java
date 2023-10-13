package com.example.demo.model;

import com.squareup.moshi.Json;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class User {

    private String name;
    private List<Role> roles;
    @Json(name = "created_at")
    private Date createdAt;

    public enum Role {
        ADMIN,
        EDITOR,
        VIEWER
    }
}
