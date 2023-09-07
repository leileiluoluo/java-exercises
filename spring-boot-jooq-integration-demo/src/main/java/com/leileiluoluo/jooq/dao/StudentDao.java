package com.leileiluoluo.jooq.dao;

import com.leileiluoluo.jooq.model.generated.tables.pojos.Student;
import com.leileiluoluo.jooq.model.generated.tables.records.StudentRecord;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Integer countAll();

    List<Student> listAll();

    List<Student> listWithPagination(int offset, int limit);

    Optional<Student> getByNo(Integer no);

    void save(Student record);

    void update(Student record);

    void deleteByNo(Integer no);

}
