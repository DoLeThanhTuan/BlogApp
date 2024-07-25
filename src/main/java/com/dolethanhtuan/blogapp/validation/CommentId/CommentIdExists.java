package com.dolethanhtuan.blogapp.validation.CommentId;

import com.dolethanhtuan.blogapp.validation.PostId.PostIdExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {CommentIdValidator.class})
@Target({ PARAMETER })
@Retention(RUNTIME)
public @interface CommentIdExists {

    String message() default "Comment id doesn't exist";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}