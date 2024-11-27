package com.example.blog_xac_thuc_phan_quyen.repository;

import com.example.blog_xac_thuc_phan_quyen.model.AppUser;
import com.example.blog_xac_thuc_phan_quyen.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
