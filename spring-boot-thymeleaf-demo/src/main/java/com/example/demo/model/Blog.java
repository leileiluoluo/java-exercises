package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private Long id;
    private String name;
    private String description;
    private boolean technical;
    private boolean deleted;

}
