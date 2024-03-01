package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@NamedStoredProcedureQuery(name = "User.getMd5EmailById", procedureName = "get_md5_email_by_id", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_id", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "md5_email", type = String.class)})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date createdAt;
    private Date updatedAt;

}
