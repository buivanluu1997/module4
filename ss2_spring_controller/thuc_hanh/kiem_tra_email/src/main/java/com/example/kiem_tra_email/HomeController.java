package com.example.kiem_tra_email;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;

    public HomeController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    private boolean validate(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam String email, Model model) {
        boolean isvalid = validate(email);
        if (isvalid) {
            model.addAttribute("email", email);
            return "success";
        } else {
            model.addAttribute("message", "Invalid email address");
            return "home";
        }
    }
}
