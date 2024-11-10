package com.example.chuyen_doi_tien_te;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Currency {
    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam double rate, @RequestParam double usd, Model model) {
        double vnd = rate * usd;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "result";
    }
}
