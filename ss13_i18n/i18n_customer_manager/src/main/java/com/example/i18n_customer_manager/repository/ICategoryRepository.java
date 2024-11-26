package com.example.i18n_customer_manager.repository;

import com.example.i18n_customer_manager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
