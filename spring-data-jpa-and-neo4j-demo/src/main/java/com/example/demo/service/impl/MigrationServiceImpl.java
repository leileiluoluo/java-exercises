package com.example.demo.service.impl;

import com.example.demo.model.graph.GraphActor;
import com.example.demo.model.graph.GraphMovie;
import com.example.demo.model.relational.Actor;
import com.example.demo.model.relational.ActorMovie;
import com.example.demo.model.relational.Movie;
import com.example.demo.repository.graph.GraphActorRepository;
import com.example.demo.repository.graph.GraphMovieRepository;
import com.example.demo.repository.relational.ActorMovieRepository;
import com.example.demo.repository.relational.ActorRepository;
import com.example.demo.repository.relational.MovieRepository;
import com.example.demo.service.MigrationService;
import com.example.demo.util.ObjectToMapUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MigrationServiceImpl implements MigrationService {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorMovieRepository actorMovieRepository;
    @Autowired
    private GraphActorRepository graphActorRepository;
    @Autowired
    private GraphMovieRepository graphMovieRepository;

    @Override
    public void migrateActorsAndMovies() {
        // migrate all actors
        migrateAllActors();

        // migrate all movies
        migrateAllMovies();

        // delete all ACTED_IN relations
        graphMovieRepository.deleteAllActedInRelations();

        // rebuild ACTED_IN relations
        List<Map<String, Object>> actedInRelations = getAllActedInRelations();
        graphMovieRepository.batchInsertOrUpdateActedInRelations(actedInRelations);
    }

    private void migrateAllActors() {
        List<Actor> actors = actorRepository.findAll();

        List<Map<String, Object>> graphActors = actors.stream()
                .map(this::assembleActor)
                .toList();

        graphActorRepository.batchInsertOrUpdate(graphActors);
    }

    private void migrateAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        List<Map<String, Object>> graphMovies = movies.stream()
                .map(this::assembleMovie)
                .toList();

        graphMovieRepository.batchInsertOrUpdate(graphMovies);
    }

    private List<Map<String, Object>> getAllActedInRelations() {
        List<ActorMovie> actorMovies = actorMovieRepository.findAll();

        return actorMovies.stream()
                .map(this::assembleActedIn)
                .toList();
    }

    private Map<String, Object> assembleActor(Actor actor) {
        GraphActor graphActor = new GraphActor();
        BeanUtils.copyProperties(actor, graphActor);
        graphActor.setId(null);

        return ObjectToMapUtil.toMap(graphActor);
    }

    private Map<String, Object> assembleMovie(Movie movie) {
        GraphMovie graphMovie = new GraphMovie();
        BeanUtils.copyProperties(movie, graphMovie);
        graphMovie.setId(null);

        return ObjectToMapUtil.toMap(graphMovie);
    }

    private Map<String, Object> assembleActedIn(ActorMovie actorMovie) {
        return Map.of(
                "actorId", actorMovie.getId().getActorId(),
                "movieId", actorMovie.getId().getMovieId(),
                "role", actorMovie.getRole()
        );
    }

}
