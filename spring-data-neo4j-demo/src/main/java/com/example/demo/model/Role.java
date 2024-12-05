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
    private Actor actor;

    public Role(String name, Actor actor) {
        this.name = name;
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actor=" + actor +
                '}';
    }
}
