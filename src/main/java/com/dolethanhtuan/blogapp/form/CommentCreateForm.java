package com.dolethanhtuan.blogapp.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentCreateForm {

    @NotBlank(message = "Name must not be blank")
    @Length(max = 50,message = "Name length must smaller than 50")
    private String name;

    @Email
    @Length(max = 75,message = "Email length must smaller than 75")
    private String email;

    @NotBlank(message = "Body must not be blank")
    @Length(max = 100,message = "Body length must smaller than 100")
    private String body;
}
