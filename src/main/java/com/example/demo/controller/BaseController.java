package com.example.demo.controller;

import com.example.demo.dto.response.ApiResponseDTO;
import com.example.demo.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Callable;

public abstract class BaseController {

    // use if you want to log request or response of api
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Transactional
    protected <T> ResponseEntity<ApiResponseDTO<T>> runInTransaction(Callable<T> function) {
        try {
            T data = function.call();
            return ResponseEntity.ok(new ApiResponseDTO<>(200, "Success", data));
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @Transactional
    protected ResponseEntity<ApiResponseDTO<Boolean>> runInTransactionForVoid(Runnable runnable) {
        try {
            runnable.run();
            return ResponseEntity.ok(new ApiResponseDTO<>(200, "Success", true)); // Success response
        } catch (Exception e) {
            return handleException(e);
        }
    }

    private <T> ResponseEntity<ApiResponseDTO<T>> handleException(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = "An unexpected error occurred";

        if (e instanceof AppException appException) {
            status = HttpStatus.valueOf(appException.getStatusCode());
            message = status.getReasonPhrase();
        }

        // logger.error("{}: {}", message, e.getMessage());

        return ResponseEntity
                .status(status)
                .body(new ApiResponseDTO<>(status.value(), message, e.getMessage()));
    }
}
