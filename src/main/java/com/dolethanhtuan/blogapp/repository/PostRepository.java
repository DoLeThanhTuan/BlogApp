package com.dolethanhtuan.blogapp.repository;

import com.dolethanhtuan.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
