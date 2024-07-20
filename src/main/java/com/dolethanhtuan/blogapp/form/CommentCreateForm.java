package com.dolethanhtuan.blogapp.form;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentCreateForm {
    private String name;
    private String email;
    private String body;
}
