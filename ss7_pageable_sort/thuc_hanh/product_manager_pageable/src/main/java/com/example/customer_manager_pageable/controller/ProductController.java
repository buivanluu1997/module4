package com.example.customer_manager_pageable.controller;

import com.example.customer_manager_pageable.model.Product;
import com.example.customer_manager_pageable.service.ICategoryService;
import com.example.customer_manager_pageable.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String listProduct(@RequestParam(required = false, defaultValue = "0") int page,
                              @RequestParam(required = false, defaultValue = "2") int size,
                              Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "price").and(Sort.by("name"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productService.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "product/list";
    }

    @GetMapping("/createProduct")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        return "product/create";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Đã thêm sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("delete", "Đã xoá sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/update")
    public String updateProductForm(@RequestParam Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categoryList", categoryService.findAllCategories());
        return "product/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("update", "Đã cập nhật thành công");
        return "redirect:/product";
    }

    @GetMapping("/listCategory")
    public String listCategory(Model model) {
        model.addAttribute("categoryList", categoryService.findAllCategories());
        return "category/listCategory";
    }
}
