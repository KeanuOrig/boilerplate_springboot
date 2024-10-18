package com.example.demo.service;

import com.example.demo.dto.auth.LoginDTO;
import com.example.demo.dto.user.CreateUserDTO;

public interface AuthService {
    String login(LoginDTO loginDto);
    CreateUserDTO register(CreateUserDTO registerDto);
}