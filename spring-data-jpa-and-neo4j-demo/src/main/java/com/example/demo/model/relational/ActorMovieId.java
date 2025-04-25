package com.example.demo.model.relational;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
public class ActorMovieId implements Serializable {

    private Long actorId;
    private Long movieId;

}
