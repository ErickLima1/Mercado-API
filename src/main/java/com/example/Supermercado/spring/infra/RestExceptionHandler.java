package com.example.Supermercado.spring.infra;

import com.example.Supermercado.spring.exceptions.NomeAlreadyExistsException;
import com.example.Supermercado.spring.exceptions.idNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(idNotExistsException.class)
    private ResponseEntity<RestErrorMessage>idNotExistsHandler(idNotExistsException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);

    }

    @ExceptionHandler(NomeAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage>NomeAlreadyHandler(NomeAlreadyExistsException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

}
