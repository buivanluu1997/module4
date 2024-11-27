package com.example.blog_xac_thuc_phan_quyen.repository;

import com.example.blog_xac_thuc_phan_quyen.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}
