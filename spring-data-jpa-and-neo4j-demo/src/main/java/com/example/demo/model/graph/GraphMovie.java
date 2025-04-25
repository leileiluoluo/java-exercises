package com.example.demo.model.graph;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("Movie")
public class GraphMovie {

    @Id
    @GeneratedValue
    private Long id;

    private Long movieId;
    private String name;
    private Integer releasedAt;

}
