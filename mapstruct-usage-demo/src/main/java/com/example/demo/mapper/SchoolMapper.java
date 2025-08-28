package com.example.demo.mapper;

import com.example.demo.dto.SchoolDto;
import com.example.demo.vo.School;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SchoolMapper {

    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);

    SchoolDto toSchoolDto(School school);

    List<SchoolDto> toSchoolDtos(List<School> schools);

}
