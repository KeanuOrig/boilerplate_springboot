package com.example.demo.exception;

public class NoResourceFoundException extends AppException {
    public NoResourceFoundException(String message) {
        super(message, 404);
    }
}
