package com.dolethanhtuan.blogapp.specification;

import com.dolethanhtuan.blogapp.entity.Post;
import com.dolethanhtuan.blogapp.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form){
        return form == null ? null : (root, query, builder) -> {
            // root để lấy ra các thuộc tính
            // buider để xây dựng các mệnh đề
            LinkedList<Predicate> predicates = new LinkedList<>();
            if(StringUtils.hasText(form.getSearch())){
                String pattern = "%"+form.getSearch()+"%";
                Predicate predicate = builder.like(root.get("title"), pattern);
                predicates.add(predicate);
            }

            if(form.getMinCreateDate() != null){
                LocalDateTime minCreateDate = LocalDateTime.of(form.getMinCreateDate(), LocalTime.MIN);
                Predicate predicate = builder.greaterThanOrEqualTo(root.get("createdAt"), minCreateDate);
                predicates.add(predicate);
            }

            if(form.getMaxCreateDate() != null){
                LocalDateTime maxCreateDate = LocalDateTime.of(form.getMaxCreateDate(), LocalTime.MAX);
                Predicate predicate = builder.lessThanOrEqualTo(root.get("createdAt"), maxCreateDate);
                predicates.add(predicate);
            }

            if(form.getStatus() != null){
                Predicate predicate = builder.equal(root.get("status"), form.getStatus());
                predicates.add(predicate);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
