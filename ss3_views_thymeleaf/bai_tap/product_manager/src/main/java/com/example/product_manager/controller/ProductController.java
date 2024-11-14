package com.example.product_manager.controller;

import com.example.product_manager.model.Product;
import com.example.product_manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String customerList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Product product, Model model, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("create", "Đã thêm sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("delete", "Đã xoá sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("update", "Đã sửa sản phâm thành công");
        return "redirect:/product";
    }

    @GetMapping("/detail")
    public String detailForm(@RequestParam int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }

    @PostMapping("/searchName")
    public String searchName(@RequestParam String name, Model model){
        List<Product> productList = productService.searchName(name);
        model.addAttribute("productList", productList);
        return "product/list";
    }
}
