package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@NoArgsConstructor
@Data
@Node
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int releasedAt;

    public Movie(String name, int releasedAt) {
        this.name = name;
        this.releasedAt = releasedAt;
    }

}
