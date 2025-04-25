package com.example.demo.repository.relational;

import com.example.demo.model.relational.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
