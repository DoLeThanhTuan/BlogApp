package com.dolethanhtuan.blogapp.controller;

import com.dolethanhtuan.blogapp.dto.CommentDTO;
import com.dolethanhtuan.blogapp.form.CommentCreateForm;
import com.dolethanhtuan.blogapp.form.CommentUpdateForm;
import com.dolethanhtuan.blogapp.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDTO> findAll(Pageable pageable){
        return commentService.findAll(pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDTO findById(@PathVariable("id") Long id){
        return commentService.findById(id);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDTO> findByPostId(@PathVariable("postId") Long postId,Pageable pageable){
        return commentService.findByPostId(postId,pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDTO create(@PathVariable("postId") Long postId,@RequestBody CommentCreateForm form){
        return commentService.create(postId, form);
    }

    @PutMapping("/api/v1/comments/{commentId}")
    public CommentDTO update(@PathVariable("commentId") Long commentId,@RequestBody CommentUpdateForm form){
        return commentService.update(commentId,form);
    }

    @DeleteMapping("/api/v1/comments/{commentId}")
    public void deleteById(@PathVariable("commentId") Long commentId){
        commentService.deleteById(commentId);
    }

}
