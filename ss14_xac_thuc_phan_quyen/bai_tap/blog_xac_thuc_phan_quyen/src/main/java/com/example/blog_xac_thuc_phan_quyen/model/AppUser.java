package com.example.blog_xac_thuc_phan_quyen.model;

import com.example.blog_xac_thuc_phan_quyen.model.blog.Blog;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "user_name", nullable = false, unique = true )
    private String userName;
    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;
    @Column(name = "enabled", length = 1, nullable = false)
    private Boolean enabled;

    @OneToMany(mappedBy = "appUser")
    private Set<Blog> blogSet;

}
