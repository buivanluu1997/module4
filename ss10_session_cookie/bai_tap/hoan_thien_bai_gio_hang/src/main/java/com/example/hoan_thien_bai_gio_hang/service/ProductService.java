package com.example.hoan_thien_bai_gio_hang.service;

import com.example.hoan_thien_bai_gio_hang.model.Product;
import com.example.hoan_thien_bai_gio_hang.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.searchByNameContains(name, pageable);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }
}
