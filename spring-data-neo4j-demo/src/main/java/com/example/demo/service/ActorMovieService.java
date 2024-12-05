package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;

import java.util.List;

public interface ActorMovieService {

    List<Movie> findMoviesByActorName(String name);

    List<Actor> findActorsByNamePrefix(String prefix);

    List<Actor> queryByExample();

}
