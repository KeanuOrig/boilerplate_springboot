package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
public class ApiResponseDTO<T> {
    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // For single error messages
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    // For list of validation errors
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ValidationErrorDTO> errors;

    // Constructor for success response
    public ApiResponseDTO(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.error = null;
        this.errors = null;
    }

    // Constructor for single error response
    public ApiResponseDTO(int code, String message, String error) {
        this.code = code;
        this.message = message;
        this.error = error;
        this.result = null;
        this.errors = null;
    }

    // Constructor for validation errors response
    public ApiResponseDTO(int code, String message, List<ValidationErrorDTO> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
        this.result = null;
        this.error = null;
    }
}
