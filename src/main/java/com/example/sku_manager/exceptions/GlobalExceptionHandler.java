package com.example.sku_manager.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error404(MethodArgumentNotValidException ex){
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMessage = fieldError.getField() + " é necessário";
        return ResponseEntity.badRequest().body("Erro de validação: " + errorMessage + ".");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        String errorMessage = ex.getMessage();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de leitura no campo: " + errorMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity errorintegrity( DataIntegrityViolationException e){
        String messageDetails = e.getRootCause().getMessage();
        return ResponseEntity.badRequest().body("Erro de validação: " + messageDetails + ".");
    }
}
