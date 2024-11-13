package com.example.product_manager.repository;

import com.example.product_manager.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void update(Product product);

    List<Product> searchName(String name);
}
