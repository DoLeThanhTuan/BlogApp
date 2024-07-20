package com.dolethanhtuan.blogapp.service.impl;

import com.dolethanhtuan.blogapp.dto.CommentDTO;
import com.dolethanhtuan.blogapp.entity.Comment;
import com.dolethanhtuan.blogapp.entity.Post;
import com.dolethanhtuan.blogapp.form.CommentCreateForm;
import com.dolethanhtuan.blogapp.form.CommentUpdateForm;
import com.dolethanhtuan.blogapp.mapper.CommentMapper;
import com.dolethanhtuan.blogapp.repository.CommentRepository;
import com.dolethanhtuan.blogapp.repository.PostRepository;
import com.dolethanhtuan.blogapp.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<CommentDTO> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(CommentMapper::map);
    }

    @Override
    public Page<CommentDTO> findByPostId(Long postId,Pageable pageable) {
        return commentRepository.findByPostId(postId,pageable)
                .map(CommentMapper::map);
    }

    @Override
    public CommentDTO findById(Long commentId) {
        return commentRepository.findById(commentId)
                .map(CommentMapper::map)
                .orElse(null);
    }

    @Override
    public CommentDTO create(Long postId, CommentCreateForm form) {
        Post post = postRepository.findById(postId).orElse(null);
        if(post == null)
            return null;
        Comment comment = CommentMapper.map(form);
        comment.setPost(post);

        return CommentMapper.map(commentRepository.save(comment));
    }

    @Override
    public CommentDTO update(Long commentId, CommentUpdateForm form) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if(comment == null) return null;
        CommentMapper.map(form,comment);
        return CommentMapper.map(commentRepository.save(comment));
    }

    @Override
    @Transactional
    public void deleteById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
        commentRepository.deleteByEmail(email);
    }

    @Override
    @Transactional
    public void deleteByNameAndEmail(String name, String email) {
        commentRepository.deleteByNameAndEmail(name,email);
    }
}
