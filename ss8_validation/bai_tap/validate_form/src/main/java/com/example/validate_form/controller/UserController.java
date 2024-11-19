package com.example.validate_form.controller;

import com.example.validate_form.dto.UserDto;
import com.example.validate_form.model.User;
import com.example.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String listUser(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "2") int size,
                           Model model) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("users", userService.findAll(pageable));
        return "user/list";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        User user = new User();
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm thành công");
        return "redirect:/user";
    }
}
