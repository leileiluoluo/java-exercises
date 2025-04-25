package com.example.demo.model.graph;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("Actor")
public class GraphActor {

    @Id
    @GeneratedValue
    private Long id;
    
    private Long actorId;
    private String name;
    private String nationality;
    private Integer yearOfBirth;

}
