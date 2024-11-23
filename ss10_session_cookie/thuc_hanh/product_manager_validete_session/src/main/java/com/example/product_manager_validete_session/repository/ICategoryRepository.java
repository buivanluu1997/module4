package com.example.product_manager_validete_session.repository;

import com.example.product_manager_validete_session.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
