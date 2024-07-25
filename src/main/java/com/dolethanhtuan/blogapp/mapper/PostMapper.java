package com.dolethanhtuan.blogapp.mapper;

import com.dolethanhtuan.blogapp.dto.PostDTO;
import com.dolethanhtuan.blogapp.entity.Post;
import com.dolethanhtuan.blogapp.entity.Status;
import com.dolethanhtuan.blogapp.form.PostCreateForm;
import com.dolethanhtuan.blogapp.form.PostUpdateForm;

public class PostMapper {
    public static Post map(PostCreateForm form){
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        post.setStatus(Status.valueOf(form.getStatus()));
        return post;
    }
    public static PostDTO map(Post post){
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setStatus(post.getStatus());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());

        return dto.withSelfRel();
    }
    public static void map(PostUpdateForm form, Post post){
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        post.setStatus(Status.valueOf(form.getStatus()));
    }
}
