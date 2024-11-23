package com.example.product_manager_validete_session.controller;

import com.example.product_manager_validete_session.dto.Card;
import com.example.product_manager_validete_session.dto.ProductDto;
import com.example.product_manager_validete_session.model.Product;
import com.example.product_manager_validete_session.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@Controller
@RequestMapping("/card")
public class CardController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String listCard(@SessionAttribute(value = "card", required = false) Card card, Model model) {
        model.addAttribute("card", card);
        DecimalFormat df = new DecimalFormat("#,###.##");
        String formattedTotal = df.format(card.totalCard());
        model.addAttribute("total", formattedTotal);
        return "/card/list";
    }

    @PostMapping("/increase")
    public String increase(@RequestParam int id, @SessionAttribute(value = "card",required = false) Card card, Model model) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        card.increaseCard(productDto);

        return "redirect:/card";
    }

    @PostMapping("/decrease")
    public String decrease(@RequestParam int id, @SessionAttribute(value = "card",required = false) Card card, Model model) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        card.decreaseCard(productDto);

        return "redirect:/card";
    }
}
