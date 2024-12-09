package com.example.quan_ly_san_pham_on_thi.service;

import com.example.quan_ly_san_pham_on_thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findByNameContaining (String name, Pageable pageable);

    void save(Product product);

    Product findById(Long id);

    void delete(Long id);

    void update(Product product);
}
