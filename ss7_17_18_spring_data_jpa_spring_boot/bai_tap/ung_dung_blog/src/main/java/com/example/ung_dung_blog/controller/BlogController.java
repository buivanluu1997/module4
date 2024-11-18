package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "/blog/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("create", "Đã thêm blog thành công");
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("delete", "Đã xoá blog thành công");
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/update";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("update", "Đã cập nhật Blog thành công");
        return "redirect:/blog";
    }

    @PostMapping("/searchAuthor")
    public String searchAuthor(@RequestParam String searchAuthor, Model model) {
        List<Blog> blogs = blogService.findByAuthor(searchAuthor);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
}
