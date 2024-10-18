package com.example.demo.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final String message;
    private final int statusCode;

    public AppException(String message, int statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
}
