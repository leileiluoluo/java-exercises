package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class School {

    private String name;
    private List<Student> students;

}
