package com.example.demo.repository.relational;

import com.example.demo.model.relational.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
