package com.victormcn.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.victormcn.authservice.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> tratarRuntimeException(
            RuntimeException ex) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (ex.getMessage().contains("não encontrado")) {
            status = HttpStatus.NOT_FOUND;
        }

        if (ex.getMessage().contains("inválida")) {
            status = HttpStatus.UNAUTHORIZED;
        }

        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(
                        status.value(),
                        ex.getMessage()));
    }
}