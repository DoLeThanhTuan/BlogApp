package com.dolethanhtuan.blogapp.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostUpdateForm {
    private String title;
    private String content;
    private String description;
}
