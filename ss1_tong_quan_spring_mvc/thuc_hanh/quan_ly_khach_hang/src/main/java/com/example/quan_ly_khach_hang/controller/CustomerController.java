package com.example.quan_ly_khach_hang.controller;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customers/list";
    }
}
