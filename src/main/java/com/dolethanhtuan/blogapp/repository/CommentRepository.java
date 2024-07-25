package com.dolethanhtuan.blogapp.repository;

import com.dolethanhtuan.blogapp.dto.CommentDTO;
import com.dolethanhtuan.blogapp.entity.Comment;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {

    // 1. Method name
    // Tiền tố: findBy, existsBy, countBy, deleteBy

    Page<Comment> findByPostId(Long postId, Pageable pageable);

    // Lấy ra tất cả comment theo name
    List<Comment> findByName(String name);

    // Lấy ra tất cả comment có body chứa từ khoá cần tìm
    List<Comment> findByBodyContaining(String search);

    // Lấy ra tất cả comment theo name hoặc email
    List<Comment> findByNameOrEmail(String name, String email);

    // Lấy ra tất cả comment theo post id
    List<Comment> findByPostId(Long postId);


    // 2. @Query

    @Query("DELETE FROM Comment WHERE email = :email")
    @Modifying
    void deleteByEmail(@Param("email") String email);

    @Query("DELETE FROM Comment WHERE name = ?1 AND email = ?2")
    @Modifying
    void deleteByNameAndEmail(String name,String email);

    @Query(value = "SELECT * FROM comment WHERE id > ?1",nativeQuery = true)
    Page<CommentDTO> findByIdGreaterThan(Long id,Pageable pageable);
}
