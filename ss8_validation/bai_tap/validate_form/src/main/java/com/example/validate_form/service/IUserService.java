package com.example.validate_form.service;

import com.example.validate_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void save(User user);
}
