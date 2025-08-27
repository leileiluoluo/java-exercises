package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.util.DateTimeUtil;
import com.example.demo.vo.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Calendar;

@Mapper(uses = DateTimeUtil.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "username")
    @Mapping(source = "yearOfBirth", target = "age", qualifiedByName = "calculateAge")
    @Mapping(target = "newCenturyUser", expression = "java(user.getYearOfBirth() >= 2000)")
    @Mapping(source = "createdAt", target = "createdDate")
    UserDto toUserDto(User user);

    @Named("calculateAge")
    default Integer calculateAge(Integer yearOfBirth) {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) - yearOfBirth;
    }

}
