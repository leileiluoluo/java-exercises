package com.example.demo.repository.relational;

import com.example.demo.model.relational.ActorMovie;
import com.example.demo.model.relational.ActorMovieId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, ActorMovieId> {

}
