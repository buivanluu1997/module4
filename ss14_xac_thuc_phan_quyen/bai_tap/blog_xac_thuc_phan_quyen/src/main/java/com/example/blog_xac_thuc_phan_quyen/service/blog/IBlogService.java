package com.example.blog_xac_thuc_phan_quyen.service.blog;

import com.example.blog_xac_thuc_phan_quyen.model.blog.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllByUserName(String username);
    List<Blog> findAll();
    boolean saveBlog(Blog blog, String username);
}
