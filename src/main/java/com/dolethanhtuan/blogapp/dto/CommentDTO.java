package com.dolethanhtuan.blogapp.dto;

import com.dolethanhtuan.blogapp.controller.CommentController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class CommentDTO extends RepresentationModel<CommentDTO> {
    private Long id;
    private String name;
    private String email;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentDTO withSelfRel(){
        CommentController controller = methodOn(CommentController.class);
        CommentDTO dto = controller.findById(this.id);
        Link link = linkTo(dto).withSelfRel();
        return add(link);
    }
}
