package com.example.sku_manager.exceptions;

import com.example.sku_manager.domain.exceptions.DomainException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataAccessException;
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

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<String> handleDomainException(DomainException ex) {
        return ResponseEntity.status(ex.getHttpStatus())
                .body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error404(MethodArgumentNotValidException ex){
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMessage = fieldError.getField() + " é necessário";
        return ResponseEntity.badRequest().body("Erro de validação: " + errorMessage + ".");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        String errorMessage = ex.getMessage();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de leitura: " + errorMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity errorintegrity( DataIntegrityViolationException e){
        String messageDetails = e.getRootCause().getMessage();
        return ResponseEntity.badRequest().body("Erro de validação: " + messageDetails + ".");
    }

    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity handleJDBCConnectionException(JDBCConnectionException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro de conexão com o banco de dados: " + e.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity handleDataAccessException(DataAccessException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao acessar o banco de dados.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity ResponseEntityhandleException(Exception e) {
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor");
    }
}
