package com.example.test_song_validate.service;

import com.example.test_song_validate.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();

    void saveCategory(Category category);

    Category getCategoryById(int id);

    void deleteCategory(int id);

    void updateCategory(Category category);


}
