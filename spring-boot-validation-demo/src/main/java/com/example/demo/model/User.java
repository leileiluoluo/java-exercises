package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class User {

    @NotNull(message = "id can not be null", groups = Update.class)
    private Long id;

    @NotNull(message = "name can not be null", groups = Add.class)
    @Size(min = 2, max = 20, message = "name length should be in the range [2, 20]")
    private String name;

    @NotNull(message = "age can not be null", groups = Add.class)
    @Range(min = 18, max = 100, message = "age should be in the range [18, 100]")
    private Integer age;

    @NotNull(message = "email can not be null", groups = Add.class)
    @Email(message = "email invalid")
    private String email;

    @NotNull(message = "phone can not be null", groups = Add.class)
    @Pattern(regexp = "^1[3-9][0-9]{9}$", message = "phone number invalid")
    private String phone;

    public interface Add extends Default {
    }

    public interface Update extends Default {
    }

}
