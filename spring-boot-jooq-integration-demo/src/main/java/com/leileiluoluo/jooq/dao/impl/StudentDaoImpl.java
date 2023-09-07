package com.leileiluoluo.jooq.dao.impl;

import com.leileiluoluo.jooq.dao.StudentDao;
import com.leileiluoluo.jooq.model.generated.tables.pojos.Student;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.leileiluoluo.jooq.model.generated.Tables.STUDENT;

@Service
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private DSLContext context;

    @Override
    public Integer countAll() {
        return context.fetchCount(STUDENT);
    }

    @Override
    public List<Student> listAll() {
        return context.selectFrom(STUDENT)
                .fetchInto(Student.class);
    }

    @Override
    public List<Student> listWithPagination(int offset, int limit) {
        return context.selectFrom(STUDENT)
                .offset(offset)
                .limit(limit)
                .fetchInto(Student.class);
    }

    @Override
    public Optional<Student> getByNo(Integer no) {
        Student student = context.select()
                .from(STUDENT)
                .where(STUDENT.NO.eq(no))
                .fetchOneInto(Student.class);

        return Optional.ofNullable(student);
    }

    @Override
    public void save(Student student) {
        context.insertInto(STUDENT)
                .set(STUDENT.NO, student.getNo())
                .set(STUDENT.NAME, student.getName())
                .set(STUDENT.GENDER, student.getGender())
                .set(STUDENT.BIRTHDAY, student.getBirthday())
                .execute();
    }

    @Override
    public void update(Student student) {
        context.update(STUDENT)
                .set(STUDENT.NAME, student.getName())
                .set(STUDENT.GENDER, student.getGender())
                .set(STUDENT.BIRTHDAY, student.getBirthday())
                .where(
                        STUDENT.NO.eq(student.getNo())
                )
                .execute();
    }

    @Override
    public void deleteByNo(Integer no) {
        context.deleteFrom(STUDENT)
                .where(
                        STUDENT.NO.eq(no)
                ).execute();
    }

}
