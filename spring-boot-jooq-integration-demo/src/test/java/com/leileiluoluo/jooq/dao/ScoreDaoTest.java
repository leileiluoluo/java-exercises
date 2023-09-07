package com.leileiluoluo.jooq.dao;

import org.jooq.Record3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ScoreDaoTest {

    @Autowired
    private ScoreDao scoreDao;

    @Test
    public void testListStudentCourseScores() {
        List<Record3<String, String, BigDecimal>> studentCourseScores = scoreDao.listStudentCourseScores();

        assertFalse(studentCourseScores.isEmpty());
    }

}
