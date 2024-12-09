package com.example.product_manager_on_thi.controller;

import com.example.product_manager_on_thi.dto.ProductDTO;
import com.example.product_manager_on_thi.model.Product;
import com.example.product_manager_on_thi.service.ICategoryService;
import com.example.product_manager_on_thi.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;

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
                                 Model model){
        Sort sort = Sort.by(Sort.Direction.ASC, "id").and(Sort.by(Sort.Direction.ASC, "name"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productService.searchProductByNameContaining(name, pageable);
        model.addAttribute("productPage", productPage);
        model.addAttribute("name", name);

        return "/product/search";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "/product/create";
    }

    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute ProductDTO productDTO, BindingResult bindingResult,
                                Model model, RedirectAttributes redirectAttributes){
        Product product = new Product();
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "/product/create";
        }
        BeanUtils.copyProperties(productDTO, product);
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("create", "Đã thêm sản phẩm thành công");
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam Long id, Model model){
        Product product = productService.getProductById(id);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "/product/update";
    }

    @PostMapping("/update")
    public String updateProduct(@Validated @ModelAttribute ProductDTO productDTO, BindingResult bindingResult,
                                Model model, RedirectAttributes redirectAttributes){
        Product product = new Product();
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "/product/update";
        }
        BeanUtils.copyProperties(productDTO, product);
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("update", "Đã cập nhật sản phẩm thành công");
        return "redirect:/products";
    }
}
