package com.dolethanhtuan.blogapp.specification;

import com.dolethanhtuan.blogapp.entity.Comment;
import com.dolethanhtuan.blogapp.form.CommentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.LinkedList;

public class CommentSpecification {
    public static Specification<Comment> buidSpec(CommentFilterForm form){
        if(form == null) return null;
        return (root, query, builder) -> {
            LinkedList<Predicate> predicates = new LinkedList<>();
            if(StringUtils.hasText(form.getSearch())){
                String pattern = "%" + form.getSearch() + "%";
                Predicate predicateName = builder.like(root.get("name"),pattern );
                Predicate predicateEmail = builder.like(root.get("email"),pattern );
                Predicate predicate = builder.or(predicateName,predicateEmail);
                predicates.add(predicate);
            }
            if(form.getPostId() != null){
                Predicate predicate = builder.equal(root.get("post").get("id"), form.getPostId());
                predicates.add(predicate);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
