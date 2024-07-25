package com.dolethanhtuan.blogapp.validation.CommentId;

import com.dolethanhtuan.blogapp.repository.CommentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentIdValidator implements ConstraintValidator<CommentIdExists,Long> {
    private CommentRepository commentRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return commentRepository.existsById(id);
    }
}
