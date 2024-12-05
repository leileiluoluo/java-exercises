package com.example.demo.repository;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testSaveAll() {
        long movieCount = movieRepository.count();

        // init data
        if (0 == movieCount) {
            Actor actor1 = new Actor("吴京", "中国", 1974);
            Actor actor2 = new Actor("卢靖姗", "中国", 1985);
            Actor actor3 = new Actor("葛优", "中国", 1957);

            List<Movie> movies = List.of(
                    new Movie("战狼 Ⅱ", 2017, List.of(
                            new Role("冷峰", actor1),
                            new Role("Rachel", actor2)
                    )),
                    new Movie("太极宗师", 1998, List.of(
                            new Role("杨昱乾", actor1)
                    )),
                    new Movie("流浪地球 Ⅱ", 2023, List.of(
                            new Role("刘培强", actor1)
                    )),
                    new Movie("我和我的家乡", 2020, List.of(
                            new Role("EMMA MEIER", actor2),
                            new Role("张北京", actor3)
                    ))
            );

            movieRepository.saveAll(movies);
        }
    }

    @Test
    public void testFindByName() {
        List<Movie> movies = movieRepository.findByName("战狼 Ⅱ");
        System.out.println(movies);
    }

    @Test
    public void testFindMovieNamesByActorName() {
        List<String> movieNames = movieRepository.findMovieNamesByActorName("吴京");
        System.out.println(movieNames);
    }

}
