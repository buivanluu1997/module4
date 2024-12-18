package com.example.product_manager_on_thi.repository;

import com.example.product_manager_on_thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> searchProductByNameContaining(String name, Pageable pageable);
}
