package com.example.quan_ly_san_pham_on_thi.service.impl;

import com.example.quan_ly_san_pham_on_thi.model.Category;
import com.example.quan_ly_san_pham_on_thi.repository.ICategoryRepository;
import com.example.quan_ly_san_pham_on_thi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
