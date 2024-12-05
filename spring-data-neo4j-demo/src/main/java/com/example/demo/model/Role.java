package com.example.demo.model;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Role {

    @RelationshipId
    private Long id;
    private String name;

    @TargetNode
    private Movie movie;

    public Role(String name, Movie movie) {
        this.name = name;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movie=" + movie +
                '}';
    }
}
