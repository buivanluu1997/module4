package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String listProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("create", "Product added successfully");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("delete", "Product deleted successfully");
        return "redirect:/product";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("update", "Product updated successfully");
        return "redirect:/product";
    }

    @GetMapping("/detail")
    public String detailForm(@RequestParam Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }
    @PostMapping("/search")
    public String searchName(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.searchByName(name));
        return "/product/list";
    }
}
