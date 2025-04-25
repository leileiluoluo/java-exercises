package com.example.demo.model.relational;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long actorId;
    private String name;
    private String nationality;
    private Integer yearOfBirth;

}
