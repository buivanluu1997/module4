package com.example.login.controller;

import com.example.login.model.Login;
import com.example.login.model.User;
import com.example.login.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String homeForm(Model model) {
        model.addAttribute("login", new Login());
        return "home";
    }

    @PostMapping("/home")
    public String login (@ModelAttribute Login login, Model model) {
        User user1 = userService.checkLogin(login);
        if (user1 != null) {
            model.addAttribute("user", user1);
            return "user";
        } else {
            model.addAttribute("message", "Login Error");
            return "error";
        }
    }
}
