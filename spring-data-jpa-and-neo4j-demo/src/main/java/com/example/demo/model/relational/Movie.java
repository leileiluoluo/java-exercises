package com.example.demo.model.relational;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long movieId;
    private String name;
    private Integer releasedAt;

}
