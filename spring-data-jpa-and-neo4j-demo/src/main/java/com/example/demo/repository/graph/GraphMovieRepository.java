package com.example.demo.repository.graph;

import com.example.demo.model.graph.GraphMovie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface GraphMovieRepository extends Neo4jRepository<GraphMovie, Long> {

    @Transactional("neo4jTransactionManager")
    @Query("""
            UNWIND $movies AS movie
            MERGE (m:Movie {movieId: movie.movieId})
            ON CREATE SET m = movie
            ON MATCH SET m += movie
            """)
    void batchInsertOrUpdate(List<Map<String, Object>> movies);

    @Transactional("neo4jTransactionManager")
    @Query("""
            MATCH (a:Actor)-[r:ACTED_IN]->(m:Movie)
            DELETE r
            """)
    void deleteAllActedInRelations();

    @Transactional("neo4jTransactionManager")
    @Query("""
            UNWIND $relations AS rel
            WITH rel
            MATCH (a:Actor {actorId: rel.actorId})
            MATCH (m:Movie {movieId: rel.movieId})
            MERGE (a)-[:ACTED_IN {role: rel.role}]->(m)
            """)
    void batchInsertOrUpdateActedInRelations(List<Map<String, Object>> relations);

}
