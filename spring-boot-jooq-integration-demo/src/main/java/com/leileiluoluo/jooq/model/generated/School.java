/*
 * This file is generated by jOOQ.
 */
package com.leileiluoluo.jooq.model.generated;


import com.leileiluoluo.jooq.model.generated.tables.Course;
import com.leileiluoluo.jooq.model.generated.tables.Score;
import com.leileiluoluo.jooq.model.generated.tables.Student;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class School extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>school</code>
     */
    public static final School SCHOOL = new School();

    /**
     * The table <code>school.course</code>.
     */
    public final Course COURSE = Course.COURSE;

    /**
     * The table <code>school.score</code>.
     */
    public final Score SCORE = Score.SCORE;

    /**
     * The table <code>school.student</code>.
     */
    public final Student STUDENT = Student.STUDENT;

    /**
     * No further instances allowed
     */
    private School() {
        super("school", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Course.COURSE,
            Score.SCORE,
            Student.STUDENT
        );
    }
}
