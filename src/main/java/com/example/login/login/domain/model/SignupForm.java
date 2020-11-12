package com.example.login.login.domain.model;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Data
public class SignupForm {

    @NotBlank
    @Email
    private String userId;

    @NotBlank
    @Length(min=4, max=100)
    @Pattern(regexp="^[a-zA-Z0-9]+$")
    private String password;

    @NotBlank
    private String userName;

    @NotNull
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;

    @Min(value=20)
    @Max(value=100)
    private int age;

    @AssertFalse
    private boolean marriage;
}
