package com.example.demo.controller;

import com.example.demo.dto.response.ApiResponseDTO;
import com.example.demo.dto.auth.LoginDTO;
import com.example.demo.dto.user.CreateUserDTO;
import com.example.demo.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends BaseController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO<String>> login(@RequestBody LoginDTO loginDTO) {
        return runInTransaction(() -> authService.login(loginDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO<CreateUserDTO>> register(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return runInTransaction(() -> authService.register(createUserDTO));
    }
}
