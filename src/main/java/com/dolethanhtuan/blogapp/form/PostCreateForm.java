package com.dolethanhtuan.blogapp.form;

import com.dolethanhtuan.blogapp.entity.Status;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostCreateForm {
    private String title;
    private String content;
    private String description;
    private Status status;
}
