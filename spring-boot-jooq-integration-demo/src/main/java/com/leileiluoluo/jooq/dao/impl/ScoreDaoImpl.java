package com.leileiluoluo.jooq.dao.impl;

import com.leileiluoluo.jooq.dao.ScoreDao;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.leileiluoluo.jooq.model.generated.Tables.*;

@Service
public class ScoreDaoImpl implements ScoreDao {

    @Autowired
    private DSLContext context;

    @Override
    public List<Record3<String, String, BigDecimal>> listStudentCourseScores() {
        return context.select(
                        STUDENT.NAME,
                        COURSE.NAME,
                        SCORE.DEGREE
                ).from(SCORE)
                .join(STUDENT).on(SCORE.STUDENT_NO.eq(STUDENT.NO))
                .join(COURSE).on(SCORE.COURSE_NO.eq(COURSE.NO))
                .fetch();
    }

}
