package com.example.blog_xac_thuc_phan_quyen.repository.blog;

import com.example.blog_xac_thuc_phan_quyen.model.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findBlogByAppUserUserName(String userName);
}
