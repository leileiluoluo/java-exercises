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
        // 构造 Moshi 实例
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();

        // 获取 User 的 JsonAdapter
        JsonAdapter<User> jsonAdapter = moshi.adapter(User.class);

        // 构造 User 对象
        User user = new User();
        user.setName("Larry");
        user.setRoles(List.of(User.Role.ADMIN, User.Role.EDITOR));
        user.setCreatedAt(new Date());

        // 序列化
        String json = jsonAdapter.toJson(user);
        System.out.println(json);

        // 反序列化
        try {
            User userParsed = jsonAdapter.fromJson(json);
            System.out.println(userParsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomTypeAdapter() {
        // 构造 Moshi 实例
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .add(new RoleAdapter())
                .build();

        // 获取 User 的 JsonAdapter
        JsonAdapter<User> jsonAdapter = moshi.adapter(User.class);

        // 构造 User 对象
        User user = new User();
        user.setName("Larry");
        user.setRoles(List.of(User.Role.ADMIN, User.Role.EDITOR));
        user.setCreatedAt(new Date());

        // 序列化
        String json = jsonAdapter.toJson(user);
        System.out.println(json);

        // 反序列化
        try {
            User userParsed = jsonAdapter.fromJson(json);
            System.out.println(userParsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJSONArrayParsing() {
        // 新建一个类型
        Type type = Types.newParameterizedType(List.class, User.class);

        // 构造 Moshi 实例
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .add(new RoleAdapter())
                .build();

        // 获取 User 的 JsonAdapter
        JsonAdapter<List<User>> jsonAdapter = moshi.adapter(type);

        // 构造 User 对象
        User user = new User();
        user.setName("Larry");
        user.setCreatedAt(new Date());
        user.setRoles(List.of(User.Role.ADMIN, User.Role.EDITOR));

        // 序列化
        String json = jsonAdapter.toJson(List.of(user));
        System.out.println(json);

        // 反序列化
        try {
            List<User> usersParsed = jsonAdapter.fromJson(json);
            System.out.println(usersParsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
