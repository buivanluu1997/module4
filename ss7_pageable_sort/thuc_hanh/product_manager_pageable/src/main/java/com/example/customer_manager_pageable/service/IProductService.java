package com.example.customer_manager_pageable.service;

import com.example.customer_manager_pageable.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(Long id);

    void delete(Long id);

    void update(Product product);
}
