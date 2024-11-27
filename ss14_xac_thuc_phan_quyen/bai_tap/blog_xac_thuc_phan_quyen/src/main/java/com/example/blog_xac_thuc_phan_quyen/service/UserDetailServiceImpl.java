package com.example.blog_xac_thuc_phan_quyen.service;

import com.example.blog_xac_thuc_phan_quyen.model.AppUser;
import com.example.blog_xac_thuc_phan_quyen.model.UserRole;
import com.example.blog_xac_thuc_phan_quyen.repository.IAppUserRepository;
import com.example.blog_xac_thuc_phan_quyen.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserName(userName);
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);
        List<UserRole> userRoleList = userRoleRepository.findByAppUser(appUser);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(grantedAuthority);
            }
        }
        UserDetails userDetails = new User(appUser.getUserName(), appUser.getEncryptedPassword(), grantList);
        return userDetails;
    }
}
