package com.example.demo.adapter;

import com.example.demo.model.User;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

public class RoleAdapter {

    @ToJson
    public String toJson(User.Role role) {
        return role.name().substring(0, 1);
    }

    @FromJson
    public User.Role fromJson(String role) {
        switch (role.charAt(0)) {
            case 'A':
                return User.Role.ADMIN;
            case 'E':
                return User.Role.EDITOR;
            case 'V':
                return User.Role.VIEWER;
        }
        return null;
    }

}
