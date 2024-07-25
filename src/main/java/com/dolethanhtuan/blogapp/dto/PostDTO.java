package com.dolethanhtuan.blogapp.dto;

import com.dolethanhtuan.blogapp.controller.PostController;
import com.dolethanhtuan.blogapp.entity.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Setter
@Getter
public class PostDTO extends RepresentationModel<PostDTO> {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public PostDTO withSelfRel(){
        PostController controller = methodOn(PostController.class);
        PostDTO dto = controller.findById(this.id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}
