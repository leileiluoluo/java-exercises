package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.neo4j.driver.types.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void testFindActorNamesByMovieName() {
        List<String> actorNames = actorRepository.findActorNamesByMovieName("战狼 Ⅱ");
        System.out.println(actorNames);
    }

    @Test
    public void testFindAverageAgeOfActorsByMovieName() {
        double averageAge = actorRepository.findAverageAgeOfActorsByMovieName("战狼 Ⅱ");
        System.out.println(averageAge);
    }

    @Test
    public void testFindShortestPathBetweenActors() {
        List<Path> paths = actorRepository.findShortestPathBetweenActors("吴京", "葛优");
        for (Path path : paths) {
            System.out.println(path);
        }
    }

    @Test
    public void testUpdateYearOfBirthByName() {
        actorRepository.updateYearOfBirthByName("吴京", 2000);
    }

}
