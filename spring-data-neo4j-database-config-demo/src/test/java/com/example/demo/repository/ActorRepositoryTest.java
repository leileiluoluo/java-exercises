package com.example.demo.repository;

import com.example.demo.model.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void testSave() {
        Actor actor = new Actor();
        actor.setName("吴京");
        actor.setNationality("中国");
        actor.setYearOfBirth(1974);

        actorRepository.save(actor);
    }

}
