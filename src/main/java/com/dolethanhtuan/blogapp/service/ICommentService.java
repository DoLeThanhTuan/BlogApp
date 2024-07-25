package com.dolethanhtuan.blogapp.service;

import com.dolethanhtuan.blogapp.dto.CommentDTO;
import com.dolethanhtuan.blogapp.form.CommentCreateForm;
import com.dolethanhtuan.blogapp.form.CommentFilterForm;
import com.dolethanhtuan.blogapp.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentService {
    Page<CommentDTO> findAll(CommentFilterForm form, Pageable pageable);
    Page<CommentDTO> findByPostId(Long postId,Pageable pageable);
    CommentDTO findById(Long commentId);
    CommentDTO create(Long postId,CommentCreateForm form);
    CommentDTO update(Long commentId,CommentUpdateForm form);
    void deleteById(Long commentId);
    void deleteByEmail(String email);
    void deleteByNameAndEmail(String name,String email);
}
