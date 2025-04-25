package com.example.demo.model.relational;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "actor_movie")
public class ActorMovie {

    @EmbeddedId
    private ActorMovieId id;
    private String role;

}
