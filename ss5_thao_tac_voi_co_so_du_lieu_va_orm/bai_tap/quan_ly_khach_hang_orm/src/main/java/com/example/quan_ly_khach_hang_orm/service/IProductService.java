package com.example.quan_ly_khach_hang_orm.service;

import com.example.quan_ly_khach_hang_orm.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void update(Product product);

    List<Product> searchName (String name);
}