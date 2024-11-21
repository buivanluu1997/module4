package com.example.luu_ten_nguoi_dung_cookie.controller;

import com.example.luu_ten_nguoi_dung_cookie.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/login")
    public String loginForm(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        model.addAttribute("cookieValue", setUser);
        return "login";
    }

    @PostMapping("do-login")
    public String doLogin(@ModelAttribute User user, @CookieValue(value = "setUser", defaultValue = "",
    required = false) String setUser, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (user.getUserName().equals("admin") && user.getPassword().equals("1234")) {
            if (user.getUserName() != null){
                setUser = user.getUserName();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (!c.getName().equals("setUser")) {
                    c.setValue("");
                }
                model.addAttribute("cookieValue", c.getValue());
            }
            model.addAttribute("mess", "Welcome " + user.getUserName());
        } else {
            user.setUserName("");
            model.addAttribute("cookieValue", "");
            model.addAttribute("mess", "Invalid username or password");
        }
        return "login";

    }
}
