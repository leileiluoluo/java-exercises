package com.example.demo.repository;

import com.example.demo.model.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ActorRepository extends Neo4jRepository<Actor, Long> {

}
