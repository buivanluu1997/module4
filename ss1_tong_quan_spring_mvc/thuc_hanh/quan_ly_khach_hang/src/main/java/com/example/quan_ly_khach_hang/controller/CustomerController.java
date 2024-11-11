package com.example.quan_ly_khach_hang.controller;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customers/list";
    }
    @GetMapping("/add")
    public String addForm(){
        return "customers/add";
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam int id, String name, String email, String address, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer(id, name, email, address);
        customerService.addCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Đã thêm thành công");
        return "redirect:/customers";
    }
}
