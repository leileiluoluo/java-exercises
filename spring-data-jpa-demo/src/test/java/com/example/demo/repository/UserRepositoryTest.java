package com.example.demo.repository;

import com.example.demo.model.User;
import jakarta.persistence.criteria.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        User user = userRepository.findById(1L);

        assertNotNull(user);
        assertEquals("Larry", user.getName());
    }

    @Test
    public void testFindAll() {
        Pageable pageable = PageRequest.of(1, 2, Sort.by("createdAt").descending());
        Page<User> page = userRepository.findAll(pageable);

        assertEquals(1, page.getContent().size());
    }

    @Test
    public void testExistsByNameAndEmail() {
        boolean exists = userRepository.existsByNameAndEmail("Larry", "larry@larry.com");

        assertTrue(exists);
    }

    @Test
    public void testFindByNameIgnoreCase() {
        List<User> users = userRepository.findByNameIgnoreCase("larry");

        assertEquals(1, users.size());
        assertEquals("Larry", users.get(0).getName());
    }

    @Test
    public void testFindByNameOrderByCreatedAtDesc() {
        List<User> users = userRepository.findByNameOrderByCreatedAtDesc("Larry");

        assertEquals(1, users.size());
        assertEquals("Larry", users.get(0).getName());
    }

    @Test
    public void testFindByNameAndAge() {
        User user = userRepository.findByNameAndAge("Larry", 18);

        assertEquals("Larry", user.getName());
    }

    @Test
    public void testGetMd5EmailUsingProcedure() {
        String md5Email = userRepository.getMd5EmailUsingProcedure(1L);

        assertEquals("844ee4ade9b36ce52a49e9f7cf73157b", md5Email);
    }

    @Test
    public void testFindAllBySpecification() {
        Specification<User> spec = (root, query, criteriaBuilder) -> {
            Predicate ageGreaterThanCondition = criteriaBuilder.greaterThan(root.get("age"), 10);
            Predicate nameLikeCondition = criteriaBuilder.like(root.get("name"), "%La%");
            return criteriaBuilder.and(ageGreaterThanCondition, nameLikeCondition);
        };

        List<User> users = userRepository.findAll(spec);
        assertEquals(1, users.size());
        assertEquals("Larry", users.get(0).getName());
    }

}
