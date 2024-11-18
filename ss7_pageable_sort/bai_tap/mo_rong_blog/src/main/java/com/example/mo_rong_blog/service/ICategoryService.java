package com.example.mo_rong_blog.service;

import com.example.mo_rong_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    void deleteById(Long id);

    Category findById(Long id);

    void update(Category category);
}
