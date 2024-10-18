package com.example.demo.dto.user;

import com.example.demo.validator.annotations.UniqueEmail;
import com.example.demo.validator.annotations.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserDTO {
    private Long id;

    @NotBlank(message = "Username is required.")
    private String username;

    @Size(min = 12, message = "Password must be at least 12 characters long.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}$",
            message = "Password must contain at least one digit, one lowercase letter, and one uppercase letter.")
    private String password;

    @NotBlank(message = "Username is required.")
    @Email(message = "Email should be valid.")
    private String email;
}