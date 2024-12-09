package com.example.quan_ly_san_pham_on_thi.repository;

import com.example.quan_ly_san_pham_on_thi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
