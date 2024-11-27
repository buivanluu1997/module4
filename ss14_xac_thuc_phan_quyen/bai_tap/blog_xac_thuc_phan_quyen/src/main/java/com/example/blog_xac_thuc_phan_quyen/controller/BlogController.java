package com.example.blog_xac_thuc_phan_quyen.controller;

import com.example.blog_xac_thuc_phan_quyen.model.blog.Blog;
import com.example.blog_xac_thuc_phan_quyen.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public String listBlog(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("blogList", blogService.findAll());
        } else {
            String userName = principal.getName();
            model.addAttribute("blogList", blogService.findAllByUserName(userName));
        }
        return "blog/list";
    }

    @GetMapping("/create")
    public String createBlogForm(Model model) {
        return "blog/create";
    }

    @PostMapping("/create")
    public String createBlog(@RequestParam String title,
                             @RequestParam String content,
                             @RequestParam(required = false, defaultValue = "") String urlImage,
                             Principal principal) {
        if (urlImage.equals("")) {
            urlImage ="https://wetrek.vn/pic/Service/mkt1@wetrek.vn/images/Choang%20ngop%20nhung%20buc%20anh%20biet%20noi%20ve%20canh%20va%20nguoi%203%20mien%20Viet%20Nam/5.jpg";
        }
        String userName = principal.getName();
        blogService.saveBlog(new Blog(title,content,urlImage), userName);
        return "redirect:/blog";
    }
}
