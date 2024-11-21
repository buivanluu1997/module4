package com.example.hoan_thien_bai_gio_hang.service;

import com.example.hoan_thien_bai_gio_hang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> searchByName (String name, Pageable pageable);

    Product findById(int id);

}
