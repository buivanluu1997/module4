package com.example.mo_rong_blog.service.impl;

import com.example.mo_rong_blog.model.Post;
import com.example.mo_rong_blog.repository.IPostRepository;
import com.example.mo_rong_blog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository postRepository;


    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(Post Post) {
        postRepository.save(Post);
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Post> findByTitleContaining(String title, Pageable pageable) {
        return postRepository.findByTitleContaining(title, pageable);
    }
}
