package com.example.demo.controller;

import com.example.demo.dto.response.ApiResponseDTO;
import com.example.demo.dto.user.UpdateUserDTO;
import com.example.demo.dto.user.CreateUserDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponseDTO<CreateUserDTO>> createUser(@Valid @RequestBody CreateUserDTO userDTO) {
        return runInTransaction(() -> userService.createUser(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<UserDTO>> getUserById(@PathVariable Long id) {
        return runInTransaction(() -> userService.getUserById(id));
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<ApiResponseDTO<UserDTO>> getUserByUsername(@PathVariable String username) {
        return runInTransaction(() -> userService.getUserByUsername(username));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<UserDTO>>> getAllUsers() {
        return runInTransaction(() -> userService.getAllUsers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Boolean>> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDTO userDTO) {
        return runInTransaction(() -> userService.updateUser(id, userDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Boolean>> deleteUser(@PathVariable Long id) {
        return runInTransactionForVoid(() -> userService.deleteUser(id));
    }
}
