/*
 * This file is generated by jOOQ.
 */
package com.leileiluoluo.jooq.model.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer no;
    private String name;

    public Course() {}

    public Course(Course value) {
        this.no = value.no;
        this.name = value.name;
    }

    public Course(
        Integer no,
        String name
    ) {
        this.no = no;
        this.name = name;
    }

    /**
     * Getter for <code>school.course.no</code>.
     */
    public Integer getNo() {
        return this.no;
    }

    /**
     * Setter for <code>school.course.no</code>.
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * Getter for <code>school.course.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>school.course.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Course other = (Course) obj;
        if (this.no == null) {
            if (other.no != null)
                return false;
        }
        else if (!this.no.equals(other.no))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.no == null) ? 0 : this.no.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Course (");

        sb.append(no);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}
