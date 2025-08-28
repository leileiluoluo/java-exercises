package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.vo.Role;
import com.example.demo.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testToUserDto() {
        User user = new User();
        user.setId(1L);
        user.setEmail("larry@larry.com");
        user.setName("Larry");
        user.setYearOfBirth(2000);
        user.setRole(Role.NORMAL);
        user.setCreatedAt(new Date());

        UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
        System.out.println(userDto);

        // reverse mapping
        User user1 = userMapper.toUser(userDto);
        System.out.println(user1);
    }

}
