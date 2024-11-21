package com.example.hoan_thien_bai_gio_hang.controller;

import com.example.hoan_thien_bai_gio_hang.model.Card;
import com.example.hoan_thien_bai_gio_hang.model.Product;
import com.example.hoan_thien_bai_gio_hang.service.IProductService;
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
    public String card(@SessionAttribute(value = "card",required = false) Card card, Model model) {
        model.addAttribute("card",card);
        DecimalFormat df = new DecimalFormat("#,###.##");
        String formattedTotal = df.format(card.totalAmount());
        model.addAttribute("total", formattedTotal);
        return "/card/list";
    }

    @GetMapping("/increaseQuantity")
    public String increaseQuantity(@RequestParam int id, @SessionAttribute(value = "card", required = false) Card card) {
        Product product = productService.findById(id);
        if (product != null) {
            card.increaseQuantity(product);
        }
        return "redirect:/card";
    }

    @GetMapping("/decreaseQuantity")
    public String decreaseQuantity(@RequestParam int id, @SessionAttribute(value = "card", required = false) Card card) {
        Product product = productService.findById(id);
        if (product != null) {
            card.decreaseQuantity(product);
        }
        return "redirect:/card";
    }
}
