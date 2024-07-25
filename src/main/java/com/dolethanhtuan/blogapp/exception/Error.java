package com.dolethanhtuan.blogapp.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
@Setter
@Getter
public class Error {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String,String> errors;

    public Error(int status,String message,Map<String ,String > errors){
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
