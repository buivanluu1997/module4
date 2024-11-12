package com.example.login.repository;

import com.example.login.model.Login;
import com.example.login.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
