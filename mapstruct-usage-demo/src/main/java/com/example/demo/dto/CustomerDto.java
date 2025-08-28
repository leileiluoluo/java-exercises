package com.example.demo.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String name;
    private Integer yearOfBirth;
    private String province;
    private String city;
    private String street;

}
