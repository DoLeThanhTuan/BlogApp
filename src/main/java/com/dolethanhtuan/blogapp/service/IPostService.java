package com.dolethanhtuan.blogapp.service;

import com.dolethanhtuan.blogapp.dto.PostDTO;
import com.dolethanhtuan.blogapp.form.PostCreateForm;
import com.dolethanhtuan.blogapp.form.PostFilterForm;
import com.dolethanhtuan.blogapp.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPostService {
    Page<PostDTO> findAll(PostFilterForm form, Pageable pageable);
    PostDTO findById(Long id);
    PostDTO create(PostCreateForm form);
    PostDTO update(Long id, PostUpdateForm form);
    void deleteById(Long id);
}
