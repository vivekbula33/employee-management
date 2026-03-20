package com.vivek.employee_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.vivek.employee_management.dto.ApiResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Map<String, String> handleException(RuntimeException ex) {
//        Map<String, String> error = new HashMap<>();
//        error.put("error", ex.getMessage());
//        return error;
//    }
    
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<String> handleException(RuntimeException ex) {
        return new ApiResponse<>("FAILURE", ex.getMessage(), null);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<String> handleValidation(MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return new ApiResponse<>("FAILURE", errorMessage, null);
    }
}
