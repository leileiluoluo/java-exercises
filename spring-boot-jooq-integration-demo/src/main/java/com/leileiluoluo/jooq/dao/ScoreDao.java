package com.leileiluoluo.jooq.dao;

import org.jooq.Record3;

import java.math.BigDecimal;
import java.util.List;

public interface ScoreDao {

    List<Record3<String, String, BigDecimal>> listStudentCourseScores();

}
