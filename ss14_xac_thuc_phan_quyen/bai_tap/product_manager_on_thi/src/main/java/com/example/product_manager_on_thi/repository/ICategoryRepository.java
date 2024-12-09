package com.example.product_manager_on_thi.repository;

import com.example.product_manager_on_thi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
