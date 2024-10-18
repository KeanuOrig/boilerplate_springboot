package com.example.demo.service;

import com.example.demo.dto.user.UpdateUserDTO;
import com.example.demo.dto.user.CreateUserDTO;
import com.example.demo.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    CreateUserDTO createUser(CreateUserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO getUserByUsername(String username);
    List<UserDTO> getAllUsers();
    Boolean updateUser(Long id, UpdateUserDTO userDTO);
    void deleteUser(Long id);
}
