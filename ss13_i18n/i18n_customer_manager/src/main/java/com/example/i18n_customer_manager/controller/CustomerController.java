package com.example.i18n_customer_manager.controller;

import com.example.i18n_customer_manager.dto.CustomerDto;
import com.example.i18n_customer_manager.model.Customer;
import com.example.i18n_customer_manager.service.ICategoryService;
import com.example.i18n_customer_manager.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String listCustomer(@RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "2") int size,
                               @RequestParam(required = false, defaultValue = "") String name, Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Customer> customerPage = customerService.findByNameContaining(name, pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("name", name);
        return "customer/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        customerService.deleteById(id);
        return "redirect:/customer";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "customer/update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        Customer customer = new Customer();
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAllCategories());
            return "customer/create";
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("create", "Đã thêm thành công");
        return "redirect:/customer";
    }
}
