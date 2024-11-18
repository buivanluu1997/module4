package com.example.customer_manager_pageable.service.impl;

import com.example.customer_manager_pageable.model.Category;
import com.example.customer_manager_pageable.repository.ICategoryRepository;
import com.example.customer_manager_pageable.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
