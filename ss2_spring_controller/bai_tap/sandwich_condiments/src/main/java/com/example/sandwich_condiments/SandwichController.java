package com.example.sandwich_condiments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @GetMapping("")
    public String sandwich() {
        return "home";
    }

    @PostMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
        model.addAttribute("condimentList", condiment);
        return "result";
    }
}
