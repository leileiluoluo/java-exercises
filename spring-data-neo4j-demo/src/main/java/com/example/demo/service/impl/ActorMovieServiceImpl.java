package com.example.demo.service.impl;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.repository.ActorRepository;
import com.example.demo.service.ActorMovieService;
import org.neo4j.cypherdsl.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActorMovieServiceImpl implements ActorMovieService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    @Override
    public List<Movie> findMoviesByActorName(String name) {
        String cypher = """
                MATCH (a:Actor)-[:ACTED_IN]->(m:Movie)
                WHERE a.name = $name
                RETURN m
                """;

        Map<String, Object> params = new HashMap<>();
        params.put("name", "吴京");

        return neo4jTemplate.findAll(cypher, params, Movie.class);
    }

    @Override
    public List<Actor> findActorsByNamePrefix(String prefix) {
        Node actor = Cypher.node("Actor").named("actor");
        Property name = actor.property("name");
        Property yearOfBirth = actor.property("yearOfBirth");

        Condition condition = name.startsWith(Cypher.anonParameter(prefix));

        return actorRepository.findAll(condition, yearOfBirth.descending())
                .stream().toList();
    }

    @Override
    public List<Actor> queryByExample() {
        Actor exampleActor = new Actor();
        exampleActor.setName("京");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnorePaths("id");

        return actorRepository.findAll(Example.of(exampleActor, matcher));
    }

}
