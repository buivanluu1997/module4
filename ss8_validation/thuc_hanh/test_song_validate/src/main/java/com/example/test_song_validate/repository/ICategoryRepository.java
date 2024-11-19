package com.example.test_song_validate.repository;

import com.example.test_song_validate.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
