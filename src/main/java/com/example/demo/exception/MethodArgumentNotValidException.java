package com.example.demo.exception;

public class MethodArgumentNotValidException extends AppException {
    public MethodArgumentNotValidException(String message) {
        super(message, 422);
    }
}
