package com.example.product_manager_on_thi.service;

import com.example.product_manager_on_thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> searchProductByNameContaining(String name, Pageable pageable);
    void saveProduct(Product product);
    Product getProductById(Long id);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
