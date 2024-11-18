package com.example.customer_manager_pageable.service;

import com.example.customer_manager_pageable.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategories();
}
