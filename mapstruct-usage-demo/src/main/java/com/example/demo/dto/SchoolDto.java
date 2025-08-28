package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class SchoolDto {

    private String name;
    private List<StudentDto> students;

}
