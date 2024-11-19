package com.example.test_song_validate.controller;

import com.example.test_song_validate.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/list";
    }
}
