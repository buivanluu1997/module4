package com.example.customer_manager_pageable.repository;

import com.example.customer_manager_pageable.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
