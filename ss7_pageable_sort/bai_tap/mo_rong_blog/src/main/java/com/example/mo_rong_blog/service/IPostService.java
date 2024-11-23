package com.example.mo_rong_blog.service;

import com.example.mo_rong_blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IPostService {
    Page<Post> findAll(Pageable pageable);

    void savePost(Post post);

    void deletePost(Long id);

    void updatePost(Post Post);

    Post findPostById(Long id);

    Page<Post> findByTitleContaining (String title, Pageable pageable);
}
