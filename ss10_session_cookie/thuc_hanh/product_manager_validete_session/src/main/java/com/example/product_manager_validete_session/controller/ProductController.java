package com.example.product_manager_validete_session.controller;

import com.example.product_manager_validete_session.dto.Card;
import com.example.product_manager_validete_session.dto.ProductDto;
import com.example.product_manager_validete_session.model.Product;
import com.example.product_manager_validete_session.service.ICategoryService;
import com.example.product_manager_validete_session.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;


@Controller
@RequestMapping("/product")
@SessionAttributes("card")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("card")
    public Card getCard() {
        return new Card();
    }

    @GetMapping("")
    public String listProducts(@RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "5") int size, Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        model.addAttribute("productPage", productService.findAll(pageable));

        return "product/list";
    }

    @GetMapping("/detail")
    public String details(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute ProductDto productDto, BindingResult bindingResult, Model model) {
        Product product = new Product();
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "product/create";
        }
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/addCard")
    public String addCard(@RequestParam int id, @SessionAttribute(value = "card", required=false) Card card, Model model) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        if (product != null) {
            BeanUtils.copyProperties(product, productDto);
            card.addCard(productDto);
        }
        model.addAttribute("card", card);
        return "redirect:/card";
    }
}
