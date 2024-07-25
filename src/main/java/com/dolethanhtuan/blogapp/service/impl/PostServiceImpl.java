package com.dolethanhtuan.blogapp.service.impl;

import com.dolethanhtuan.blogapp.dto.PostDTO;
import com.dolethanhtuan.blogapp.entity.Post;
import com.dolethanhtuan.blogapp.form.PostCreateForm;
import com.dolethanhtuan.blogapp.form.PostFilterForm;
import com.dolethanhtuan.blogapp.form.PostUpdateForm;
import com.dolethanhtuan.blogapp.mapper.PostMapper;
import com.dolethanhtuan.blogapp.repository.PostRepository;
import com.dolethanhtuan.blogapp.service.IPostService;
import com.dolethanhtuan.blogapp.specification.PostSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PostServiceImpl implements IPostService {
    private PostRepository postRepository;

    @Override
    public Page<PostDTO> findAll(PostFilterForm form, Pageable pageable) {
        Specification<Post> spec = PostSpecification.buildSpec(form);
        return postRepository.findAll(spec,pageable)
                .map(PostMapper::map);
    }

    @Override
    public PostDTO findById(Long id) {
        return postRepository.findById(id).map(PostMapper::map).orElse(null);
    }

    @Override
    public PostDTO create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public PostDTO update(Long id,PostUpdateForm form) {
        var optional = postRepository.findById(id);
        if(optional.isEmpty()) return null;
        var post = optional.get();
        PostMapper.map(form, post);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
