package com.produtos.produtos.View.Handler;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControlerAdvince extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders handler,
            HttpStatus status, WebRequest request) {

        List<String> mensagens = ex.getBindingResult()
            .getFieldErrors()
            .stream()            
            .map(DefaultMessageSourceResolvable::getDefaultMessage) 
            .collect(Collectors.toList());
            
        BadRequestDTO dto = new BadRequestDTO(mensagens);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);                
    }    
}
