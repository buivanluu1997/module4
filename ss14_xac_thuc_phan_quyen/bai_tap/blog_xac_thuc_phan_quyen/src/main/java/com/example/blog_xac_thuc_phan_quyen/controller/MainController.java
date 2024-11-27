package com.example.blog_xac_thuc_phan_quyen.controller;

import com.example.blog_xac_thuc_phan_quyen.ultil.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String homePage(Model model){
        model.addAttribute("title", "Chào mừng bạn đến với trang chúng tôi");
        return "homePage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "loginPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal){
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);

        System.out.println("-----------------detail----------");
        System.out.println(userInfo);
        return "userInfo";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessful(Model model){
        model.addAttribute("title", "Bạn đã đăng xuất thành công");
        return "logout";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model){
        model.addAttribute("title", "Helloooooo Admin");
        return "adminPage";
    }
}
