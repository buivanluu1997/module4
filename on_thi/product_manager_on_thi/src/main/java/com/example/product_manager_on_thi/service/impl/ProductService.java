package com.example.product_manager_on_thi.service.impl;

import com.example.product_manager_on_thi.model.Product;
import com.example.product_manager_on_thi.repository.IProductRepository;
import com.example.product_manager_on_thi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<Product> searchProductByNameContaining(String name, Pageable pageable) {
        return productRepository.searchProductByNameContaining(name, pageable);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
