package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void deleteById(Long id);

    void update(Blog blog);
}
