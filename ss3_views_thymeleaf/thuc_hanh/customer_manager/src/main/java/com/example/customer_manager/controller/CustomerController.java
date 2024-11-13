package com.example.customer_manager.controller;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.service.CustomerService;
import com.example.customer_manager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String customerList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "list";
    }

    @GetMapping("/create")
    public String addForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String addCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Đã thêm khách hàng thành công");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("delete", "Đã xoá khách hàng thành công");
        return "redirect:/customer";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("update", "Đã cập nhật thành công");
        return "redirect:/customer";
    }

    @GetMapping("/detail")
    public String detailCustomer(@RequestParam int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "detail";
    }
}
