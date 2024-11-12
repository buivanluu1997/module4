package com.example.mailbox.controller;

import com.example.mailbox.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mailbox")
public class MailBoxController {


    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("mailbox", new MailBox());
        return "home";
    }

    @PostMapping("/home")
    public String view(@ModelAttribute MailBox mailbox, Model model) {
        model.addAttribute("mailbox", mailbox);
        return "view";
    }
}
