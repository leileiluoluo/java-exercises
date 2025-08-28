package com.example.demo.mapper;

import com.example.demo.dto.SchoolDto;
import com.example.demo.vo.School;
import com.example.demo.vo.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SchoolMapperTest {

    @Test
    public void testToSchoolDto() {
        Student student = new Student();
        student.setName("Larry");
        student.setGender("Male");
        student.setAge(20);

        School school = new School();
        school.setName("Beijing NO.1 High School");
        school.setStudents(List.of(student));

        SchoolDto schoolDto = SchoolMapper.INSTANCE.toSchoolDto(school);
        System.out.println(schoolDto);
    }

}
