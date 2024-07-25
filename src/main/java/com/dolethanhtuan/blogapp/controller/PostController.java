package com.dolethanhtuan.blogapp.controller;

import com.dolethanhtuan.blogapp.dto.PostDTO;
import com.dolethanhtuan.blogapp.form.PostCreateForm;
import com.dolethanhtuan.blogapp.form.PostFilterForm;
import com.dolethanhtuan.blogapp.form.PostUpdateForm;
import com.dolethanhtuan.blogapp.service.IPostService;
import com.dolethanhtuan.blogapp.validation.PostId.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
@AllArgsConstructor
public class PostController {
    private IPostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDTO> findAll(PostFilterForm form, Pageable pageable){
        return postService.findAll(form,pageable);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostDTO findById(@PathVariable("id") @PostIdExists Long id){
        return postService.findById(id);
    }
    @PostMapping("/api/v1/posts")
    public PostDTO create(@Valid @RequestBody PostCreateForm form){
        return postService.create(form);
    }
    @PutMapping("/api/v1/posts/{id}")
    public PostDTO update(@PathVariable("id") @PostIdExists Long id,@Valid @RequestBody PostUpdateForm form){
        return postService.update(id,form);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") @PostIdExists Long id){
        postService.deleteById(id);
    }
}
