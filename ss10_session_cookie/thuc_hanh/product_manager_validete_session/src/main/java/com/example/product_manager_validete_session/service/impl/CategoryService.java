package com.example.product_manager_validete_session.service.impl;

import com.example.product_manager_validete_session.model.Category;
import com.example.product_manager_validete_session.repository.ICategoryRepository;
import com.example.product_manager_validete_session.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
