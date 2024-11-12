package com.example.login.service;

import com.example.login.model.Login;
import com.example.login.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
