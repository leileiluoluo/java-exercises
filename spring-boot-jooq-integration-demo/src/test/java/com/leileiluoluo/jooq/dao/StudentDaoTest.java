package com.leileiluoluo.jooq.dao;

import com.leileiluoluo.jooq.model.generated.tables.pojos.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testCountAll() {
        Integer count = studentDao.countAll();

        assertTrue(count > 0);
    }

    @Test
    public void testListAll() {
        List<Student> students = studentDao.listAll();

        assertFalse(students.isEmpty());
    }

    @Test
    public void testListWithPagination() {
        List<Student> students = studentDao.listWithPagination(0, 10);

        assertFalse(students.isEmpty());
    }

    @Test
    public void testGetByNo() {
        Optional<Student> student = studentDao.getByNo(1);

        assertTrue(student.isPresent());
    }

}
