package com.example.i18n_customer_manager.service.impl;

import com.example.i18n_customer_manager.model.Category;
import com.example.i18n_customer_manager.repository.ICategoryRepository;
import com.example.i18n_customer_manager.service.ICategoryService;
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
