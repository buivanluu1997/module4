package com.example.quan_ly_san_pham_on_thi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

    @Setter
    @Getter
    @NoArgsConstructor
    @Entity
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private double price;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate createdAt;

        @ManyToOne
        @JoinColumn(name = "category_id", referencedColumnName = "id")
        private Category category;
    }
