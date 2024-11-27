package com.example.blog_xac_thuc_phan_quyen.service.blog;

import com.example.blog_xac_thuc_phan_quyen.model.AppUser;
import com.example.blog_xac_thuc_phan_quyen.model.blog.Blog;
import com.example.blog_xac_thuc_phan_quyen.repository.IAppUserRepository;
import com.example.blog_xac_thuc_phan_quyen.repository.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private IAppUserRepository appUserRepository;

    @Override
    public List<Blog> findAllByUserName(String username) {
        return blogRepository.findBlogByAppUserUserName(username);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public boolean saveBlog(Blog blog, String username) {
        AppUser appUser = appUserRepository.findByUserName(username);
        blog.setAppUser(appUser);
        blogRepository.save(blog);
        return true;
    }
}
