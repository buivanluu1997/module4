package com.example.hoan_thien_bai_gio_hang.repository;

import com.example.hoan_thien_bai_gio_hang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> searchByNameContains(String name, Pageable pageable);
}
