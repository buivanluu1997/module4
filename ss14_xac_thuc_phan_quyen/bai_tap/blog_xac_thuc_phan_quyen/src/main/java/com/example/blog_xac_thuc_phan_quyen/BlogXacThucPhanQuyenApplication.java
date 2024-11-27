package com.example.blog_xac_thuc_phan_quyen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogXacThucPhanQuyenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogXacThucPhanQuyenApplication.class, args);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }

}
