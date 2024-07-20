package com.dolethanhtuan.blogapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 50,name = "name")
    private String name;

    @Column(nullable = false, length = 75,name = "email")
    private String email;

    @Column(nullable = false, length = 100,name = "body")
    private String body;

    @Column(name = "create_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Post post;
}
