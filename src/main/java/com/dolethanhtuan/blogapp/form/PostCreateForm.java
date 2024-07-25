package com.dolethanhtuan.blogapp.form;

import com.dolethanhtuan.blogapp.entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
public class PostCreateForm {

    @NotBlank(message = "Post title must not be blank")
    @Length(max = 50,message = "Post title length max is 50")
    private String title;

    @NotBlank(message = "Post content must not be blank")
    @Length(max = 150,message = "Post content length max is 150")
    private String content;

    @NotBlank(message = "Post content must not be blank")
    @Length(max = 150,message = "Post description length max is 100")
    private String description;

    @NotNull
    @Pattern(regexp = "OPENING|CLOSED", message = "Post status must be OPENING OR ClOSED")
    private String status;
}
