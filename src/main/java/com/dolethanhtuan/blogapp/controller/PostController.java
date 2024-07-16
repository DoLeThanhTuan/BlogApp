package com.dolethanhtuan.blogapp.controller;

import com.dolethanhtuan.blogapp.dto.PostDTO;
import com.dolethanhtuan.blogapp.form.PostCreateForm;
import com.dolethanhtuan.blogapp.form.PostUpdateForm;
import com.dolethanhtuan.blogapp.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private IPostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDTO> findAll(Pageable pageable){
        return postService.findAll(pageable);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostDTO findById(@PathVariable("id") Long id){
        return postService.findById(id);
    }
    @PostMapping("/api/v1/posts")
    public PostDTO create(@RequestBody PostCreateForm form){
        return postService.create(form);
    }
    @PutMapping("/api/v1/posts/{id}")
    public PostDTO update(@PathVariable("id") Long id,@RequestBody PostUpdateForm form){
        return postService.update(id,form);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id){
        postService.deleteById(id);
    }
}
