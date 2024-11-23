package com.example.product_manager_validete_session.repository;

import com.example.product_manager_validete_session.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAll(Pageable pageable);
}
