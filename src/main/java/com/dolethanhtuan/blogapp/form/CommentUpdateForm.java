package com.dolethanhtuan.blogapp.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentUpdateForm {
    @NotBlank(message = "Name must not be blank")
    @Length(max = 50,message = "Name length must smaller than 50")
    private String name;
    @NotBlank(message = "Email must not be blank")
    @Length(max = 75,message = "Email length must smaller than 75")
    private String email;
    @NotBlank(message = "Body must not be blank")
    @Length(max = 100,message = "Body length must smaller than 100")
    private String body;
}
