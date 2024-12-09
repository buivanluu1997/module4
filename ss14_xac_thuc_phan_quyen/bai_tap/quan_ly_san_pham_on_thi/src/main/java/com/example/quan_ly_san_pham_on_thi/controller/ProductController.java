package com.example.quan_ly_san_pham_on_thi.controller;

import com.example.quan_ly_san_pham_on_thi.dto.ProductDTO;
import com.example.quan_ly_san_pham_on_thi.model.Product;
import com.example.quan_ly_san_pham_on_thi.service.ICategoryService;
import com.example.quan_ly_san_pham_on_thi.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String searchProducts(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "2") int size,
                                 @RequestParam(required = false, defaultValue = "") String name,
                                 Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.findByNameContaining(name, pageable);
        model.addAttribute("productPage", productPage);
        return "/product/list";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id, Model model) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("product", product);
        return "/product/update";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("update", "Đã cập nhật sản phẩm thành công");
        return "redirect:/products";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/product/create";
    }

    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute ProductDTO productDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Product product = new Product();

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            return "/product/create";
        }
        BeanUtils.copyProperties(productDTO, product);

        productService.save(product);
        redirectAttributes.addFlashAttribute("create", "Đã thêm sản phẩm thành công");
        return "redirect:/products";
    }
}
