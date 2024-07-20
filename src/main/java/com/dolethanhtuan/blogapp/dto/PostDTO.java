package com.dolethanhtuan.blogapp.dto;

import com.dolethanhtuan.blogapp.entity.Status;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Setter
@Getter
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
