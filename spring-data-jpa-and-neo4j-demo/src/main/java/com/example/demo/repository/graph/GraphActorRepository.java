package com.example.demo.repository.graph;

import com.example.demo.model.graph.GraphActor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface GraphActorRepository extends Neo4jRepository<GraphActor, Long> {

    @Transactional("neo4jTransactionManager")
    @Query("""
            UNWIND $actors AS actor
            MERGE (a:Actor {actorId: actor.actorId})
            ON CREATE SET a = actor
            ON MATCH SET a += actor
            """)
    void batchInsertOrUpdate(List<Map<String, Object>> actors);

}
