package com.example.mo_rong_blog.dto;

import com.example.mo_rong_blog.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    private int id;
    private String title;
    private LocalDate createdAt;
    private Category category;
}
