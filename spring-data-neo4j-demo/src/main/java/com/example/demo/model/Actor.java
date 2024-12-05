package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@NoArgsConstructor
@Data
@Node
public class Actor {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String nationality;
    private int yearOfBirth;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.OUTGOING)
    private List<Role> rolesAndMovies;

    public Actor(String name, String nationality, int yearOfBirth, List<Role> rolesAndMovies) {
        this.name = name;
        this.nationality = nationality;
        this.yearOfBirth = yearOfBirth;
        this.rolesAndMovies = rolesAndMovies;
    }

}
