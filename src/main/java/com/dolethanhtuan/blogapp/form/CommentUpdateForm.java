package com.dolethanhtuan.blogapp.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateForm {
    private String name;
    private String email;
    private String body;
}
