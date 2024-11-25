package com.example.product_manager_validete_session.service;

import com.example.product_manager_validete_session.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
}
