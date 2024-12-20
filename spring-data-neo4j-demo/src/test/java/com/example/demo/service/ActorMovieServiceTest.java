package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActorMovieServiceTest {

    @Autowired
    private ActorMovieService actorMovieService;

    @Test
    public void testGetMoviesByActorName() {
        List<Movie> movies = actorMovieService.findMoviesByActorName("吴京");
        System.out.println(movies);
    }

    @Test
    public void testFindActorsByNamePrefix() {
        List<Actor> actors = actorMovieService.findActorsByNamePrefix("吴");
        System.out.println(actors);
    }

    @Test
    public void testFindActorsByNamePrefixWithQueryByExample() {
        List<Actor> actors = actorMovieService.findActorsByNamePrefixWithQueryByExample("吴");
        System.out.println(actors);
    }

    @Test
    public void testUpdateMovie() {
        Movie movie = new Movie();
        movie.setId(6L);
        movie.setName("战狼 2");
        actorMovieService.updateMovie(movie);
    }

}
