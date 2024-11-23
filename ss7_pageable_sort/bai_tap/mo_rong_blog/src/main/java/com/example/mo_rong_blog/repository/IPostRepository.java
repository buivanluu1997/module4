package com.example.mo_rong_blog.repository;

import com.example.mo_rong_blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IPostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByTitleContaining (String title, Pageable pageable);
    Page<Post> findAll(Pageable pageable);
}
