package com.example.demo.repository;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.model.Role;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.types.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    public void testSaveAll() {
        Movie movie1 = new Movie("战狼 Ⅱ", 2017);
        Movie movie2 = new Movie("太极宗师", 1998);
        Movie movie3 = new Movie("流浪地球 Ⅱ", 2023);
        Movie movie4 = new Movie("我和我的家乡", 2020);

        Role role1 = new Role("冷峰", movie1);
        Role role2 = new Role("杨昱乾", movie2);
        Role role3 = new Role("刘培强", movie3);
        Role role4 = new Role("Rachel", movie1);
        Role role5 = new Role("EMMA MEIER", movie4);

        List<Actor> actors = List.of(
                new Actor("吴京", "中国", 1974, List.of(role1, role2, role3)),
                new Actor("卢靖姗", "中国", 1985, List.of(role4, role5))
        );

        actorRepository.saveAll(actors);
    }

    @Test
    public void testFindByName() {
        List<Actor> actors = actorRepository.findByName("吴京");
        actors.forEach(actor -> {
                    System.out.println("id: " + actor.getId());
                    System.out.println("name: " + actor.getName());
                    System.out.println("nationality: " + actor.getNationality());
                    System.out.println("yearOfBirth: " + actor.getYearOfBirth());
                    System.out.println("rolesAndMovies: " + actor.getRolesAndMovies());
                }
        );
    }

    @Test
    public void testFindMovieNamesByActorName() {
        List<String> movieNames = actorRepository.findMovieNamesByActorName("吴京");
        System.out.println(movieNames);
    }

    @Test
    public void testFindActorNamesByMovieName() {
        List<String> actorNames = actorRepository.findActorNamesByMovieName("战狼 Ⅱ");
        System.out.println(actorNames);
    }

    @Test
    public void testFindAverageAgeOfActorsByMovieName() {
        double averageAge = actorRepository.findAverageAgeOfActorsByMovieName("战狼 Ⅱ 2");
        System.out.println(averageAge);
    }

    @Test
    public void testFindShortestPathBetweenActors() {
        List<Path> shortestPaths = actorRepository.findShortestPathBetweenActors("吴京", "卢靖姗", 10);
        System.out.println(shortestPaths);
    }

}
