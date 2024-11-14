package com.example.quan_ly_khach_hang_orm.controller;

import com.example.quan_ly_khach_hang_orm.model.Product;
import com.example.quan_ly_khach_hang_orm.service.IProductService;
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
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("create", "Đã thêm sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("delete", "Đã xoá sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("update", "Đã cập nhật sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/detail")
    public String detailProduct(@RequestParam int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }

    @PostMapping("/searchName")
    public String searchName(@RequestParam String name, Model model){
        model.addAttribute("productList", productService.searchName(name));
        return "product/search";
    }
}
