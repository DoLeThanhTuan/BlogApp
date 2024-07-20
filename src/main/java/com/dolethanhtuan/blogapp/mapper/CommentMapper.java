package com.dolethanhtuan.blogapp.mapper;

import com.dolethanhtuan.blogapp.dto.CommentDTO;
import com.dolethanhtuan.blogapp.entity.Comment;
import com.dolethanhtuan.blogapp.form.CommentCreateForm;
import com.dolethanhtuan.blogapp.form.CommentUpdateForm;

public class CommentMapper {
    public static Comment map(CommentCreateForm form){
        Comment comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }
    public static CommentDTO map(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setEmail(comment.getEmail());
        commentDTO.setBody(comment.getBody());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        commentDTO.setUpdatedAt(comment.getUpdatedAt());
        return commentDTO;
    }
    public static void map(CommentUpdateForm form , Comment comment){
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
    }
}
