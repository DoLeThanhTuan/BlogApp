package com.dolethanhtuan.blogapp.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class HandleError extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = "Invalid form data";
        Map<String,String> errors = new LinkedHashMap<String,String>();
        for (var error : ex.getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        Error response = new Error(status.value(),message,errors);
        return new ResponseEntity<>(response, headers,status.value());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        String message = "Invalid data";
        Map<String,String> errors = new LinkedHashMap<String,String>();
        for(var i : ex.getConstraintViolations()){
            errors.put(i.getPropertyPath().toString(),i.getMessage());
        }
        Error response = new Error(HttpStatus.BAD_REQUEST.value(), message, errors);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST );
    }
}
