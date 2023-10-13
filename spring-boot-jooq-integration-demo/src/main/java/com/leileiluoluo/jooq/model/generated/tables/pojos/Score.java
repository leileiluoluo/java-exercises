/*
 * This file is generated by jOOQ.
 */
package com.leileiluoluo.jooq.model.generated.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer studentNo;
    private Integer courseNo;
    private BigDecimal degree;

    public Score() {}

    public Score(Score value) {
        this.studentNo = value.studentNo;
        this.courseNo = value.courseNo;
        this.degree = value.degree;
    }

    public Score(
        Integer studentNo,
        Integer courseNo,
        BigDecimal degree
    ) {
        this.studentNo = studentNo;
        this.courseNo = courseNo;
        this.degree = degree;
    }

    /**
     * Getter for <code>school.score.student_no</code>.
     */
    public Integer getStudentNo() {
        return this.studentNo;
    }

    /**
     * Setter for <code>school.score.student_no</code>.
     */
    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    /**
     * Getter for <code>school.score.course_no</code>.
     */
    public Integer getCourseNo() {
        return this.courseNo;
    }

    /**
     * Setter for <code>school.score.course_no</code>.
     */
    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    /**
     * Getter for <code>school.score.degree</code>.
     */
    public BigDecimal getDegree() {
        return this.degree;
    }

    /**
     * Setter for <code>school.score.degree</code>.
     */
    public void setDegree(BigDecimal degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Score other = (Score) obj;
        if (this.studentNo == null) {
            if (other.studentNo != null)
                return false;
        }
        else if (!this.studentNo.equals(other.studentNo))
            return false;
        if (this.courseNo == null) {
            if (other.courseNo != null)
                return false;
        }
        else if (!this.courseNo.equals(other.courseNo))
            return false;
        if (this.degree == null) {
            if (other.degree != null)
                return false;
        }
        else if (!this.degree.equals(other.degree))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.studentNo == null) ? 0 : this.studentNo.hashCode());
        result = prime * result + ((this.courseNo == null) ? 0 : this.courseNo.hashCode());
        result = prime * result + ((this.degree == null) ? 0 : this.degree.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Score (");

        sb.append(studentNo);
        sb.append(", ").append(courseNo);
        sb.append(", ").append(degree);

        sb.append(")");
        return sb.toString();
    }
}