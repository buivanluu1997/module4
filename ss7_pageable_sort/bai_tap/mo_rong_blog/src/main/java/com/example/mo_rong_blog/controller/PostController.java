package com.example.mo_rong_blog.controller;

import com.example.mo_rong_blog.model.Category;
import com.example.mo_rong_blog.model.Post;
import com.example.mo_rong_blog.service.ICategoryService;
import com.example.mo_rong_blog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPostService postService;

    @GetMapping("")
    public String search(@RequestParam(required = false, defaultValue = "0") int page,
                         @RequestParam(required = false, defaultValue = "3") int size,
                         @RequestParam(required = false, defaultValue = "") String searchTitle,
                         Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "title").and(Sort.by( "createdAt"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Post> postPage = postService.findByTitleContaining(searchTitle, pageable);
        model.addAttribute("postPage", postPage);
        model.addAttribute("searchTitle", searchTitle);
        return "post/listPost";
    }

    @GetMapping("/createPost")
    public String createPostForm(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("post", new Post());
        return "post/createPost";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("post") Post post, RedirectAttributes redirectAttributes) {
        postService.savePost(post);
        redirectAttributes.addFlashAttribute("createPost", "Đã thêm thành công");
        return "redirect:/post";
    }

    @GetMapping("/deletePost")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        postService.deletePost(id);
        redirectAttributes.addFlashAttribute("deletePost", "Đã xoá thành công");
        return "redirect:/post";
    }

    @GetMapping("/updatePost")
    public String updatePostForm(@RequestParam Long id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("post", postService.findPostById(id));
        return "post/updatePost";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute("post") Post post, RedirectAttributes redirectAttributes) {
        postService.updatePost(post);
        redirectAttributes.addFlashAttribute("updatePost", "Đã cập nhật thành công");
        return "redirect:/post";
    }



    @GetMapping("/listCategory")
    public String listCategory(Model model) {
       model.addAttribute("listCategory", categoryService.findAll());
       return "category/listCategory";
   }

   @GetMapping("/createCategory")
    public String createCategoryForm(Model model) {
       model.addAttribute("category", new Category());
       return "category/createCategory";
   }

   @PostMapping("createCategory")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
       categoryService.save(category);
       redirectAttributes.addFlashAttribute("createCate","Đã tạo danh mục thành công");
       return "redirect:/post/listCategory";
   }

   @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam Long id, RedirectAttributes redirectAttributes) {
       categoryService.deleteById(id);
       redirectAttributes.addFlashAttribute("deleteCate", "Đã xoá danh mục thành công");
       return "redirect:/post/listCategory";
   }

   @GetMapping("/updateCategory")
    public String updateCategoryForm(@RequestParam Long id, Model model) {
       model.addAttribute("category", categoryService.findById(id));
       return "category/updateCategory";
   }

   @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
       categoryService.update(category);
       redirectAttributes.addFlashAttribute("updateCate","Đã cập nhật danh mục thành công");
       return "redirect:/post/listCategory";
   }

}
