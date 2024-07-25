package com.dolethanhtuan.blogapp.controller;

import com.dolethanhtuan.blogapp.dto.CommentDTO;
import com.dolethanhtuan.blogapp.form.CommentCreateForm;
import com.dolethanhtuan.blogapp.form.CommentFilterForm;
import com.dolethanhtuan.blogapp.form.CommentUpdateForm;
import com.dolethanhtuan.blogapp.service.ICommentService;
import com.dolethanhtuan.blogapp.validation.CommentId.CommentIdExists;
import com.dolethanhtuan.blogapp.validation.PostId.PostIdExists;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDTO> findAll(CommentFilterForm form, Pageable pageable){
        return commentService.findAll(form,pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDTO findById(@PathVariable("id") @CommentIdExists Long id){
        return commentService.findById(id);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDTO> findByPostId(@PathVariable("postId") @PostIdExists Long postId, Pageable pageable){
        return commentService.findByPostId(postId,pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDTO create(@PathVariable("postId") @PostIdExists Long postId,@Valid @RequestBody CommentCreateForm form){
        return commentService.create(postId, form);
    }

    @PutMapping("/api/v1/comments/{commentId}")
    public CommentDTO update(@PathVariable("commentId") @CommentIdExists Long commentId,@Valid @RequestBody CommentUpdateForm form){
        return commentService.update(commentId,form);
    }

    @DeleteMapping("/api/v1/comments/{commentId}")
    public void deleteById(@PathVariable("commentId") @CommentIdExists Long commentId){
        commentService.deleteById(commentId);
    }

}
