package com.example.hoan_thien_bai_gio_hang.controller;

import com.example.hoan_thien_bai_gio_hang.model.Card;
import com.example.hoan_thien_bai_gio_hang.model.Product;
import com.example.hoan_thien_bai_gio_hang.service.IProductService;
import com.example.hoan_thien_bai_gio_hang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@SessionAttributes("card")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("card")
    public Card initCart() {
        return new Card();
    }

    @GetMapping("")
    public String searchProduct(@RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "2") int size,
                                @RequestParam(required = false, defaultValue = "") String name, Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productService.searchByName(name, pageable);

        model.addAttribute("productPage", productPage);
        return "/product/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/detail";
    }

    @GetMapping("/addToCard")
        public String addToCard(@RequestParam int id, @ModelAttribute("card") Card card) {
        Product product = productService.findById(id);
        if (product != null) {
            card.addToCard(product);
        }
        return "redirect:/card";
    }


}
