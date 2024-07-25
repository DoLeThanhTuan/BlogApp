package com.dolethanhtuan.blogapp.form;

import com.dolethanhtuan.blogapp.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostFilterForm {
    private String search;
    private LocalDate minCreateDate;
    private LocalDate maxCreateDate;
    private Status status;

}
