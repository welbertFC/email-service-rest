package com.email.emailservicerest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResourceExceptionHandler {

    public static final String VALIDATION_ERROR = "Validation error";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError<Map<String, String>>> validation(
            MethodArgumentNotValidException e, HttpServletRequest request) {

        var errors = new HashMap<String, String>();

        e.getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(),
                fieldError.getDefaultMessage() != null ? fieldError.getDefaultMessage() : ""));

        return ResponseEntity.badRequest().body(new StandardError<>(
                HttpStatus.BAD_REQUEST.value(),
                VALIDATION_ERROR,
                errors,
                Calendar.getInstance().getTimeInMillis(),
                request.getRequestURI()));
    }
}
