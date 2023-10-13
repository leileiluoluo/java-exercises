package com.example.demo;

import com.example.demo.adapter.RoleAdapter;
import com.example.demo.model.User;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class MoshiTest {

    @Test
    public void testBasicUsage() {
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();
        JsonAdapter<User> jsonAdapter = moshi.adapter(User.class);

        User user = new User();
        user.setName("Larry");
        user.setRoles(List.of(User.Role.ADMIN, User.Role.EDITOR));
        user.setCreatedAt(new Date());

        // serialization
        String json = jsonAdapter.toJson(user);
        System.out.println(json);

        // deserialization
        try {
            User userParsed = jsonAdapter.fromJson(json);
            System.out.println(userParsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUserSerializationAndDeserialization() throws IOException {
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .add(new RoleAdapter())
                .build();
        JsonAdapter<User> jsonAdapter = moshi.adapter(User.class);

        User user = new User();
        user.setName("Larry");
        user.setCreatedAt(new Date());
        user.setRoles(List.of(User.Role.ADMIN, User.Role.EDITOR));

        // serialization
        String json = jsonAdapter.toJson(user);
        System.out.println(json);

        // deserialization
        System.out.println(jsonAdapter.fromJson(json));
    }

    @Test
    public void testUserListSerializationAndDeserialization() throws IOException {
        Type type = Types.newParameterizedType(List.class, User.class);

        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .add(new RoleAdapter())
                .build();
        JsonAdapter<List<User>> jsonAdapter = moshi.adapter(type);

        User user = new User();
        user.setName("Larry");
        user.setCreatedAt(new Date());
        user.setRoles(List.of(User.Role.ADMIN, User.Role.EDITOR));

        // serialization
        String json = jsonAdapter.toJson(List.of(user));
        System.out.println(json);

        // deserialization
        System.out.println(jsonAdapter.fromJson(json));
    }

}
