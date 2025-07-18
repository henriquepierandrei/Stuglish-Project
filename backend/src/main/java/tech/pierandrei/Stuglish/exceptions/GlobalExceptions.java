package tech.pierandrei.Stuglish.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(CredentialsUnauthorizedException.class)
    public ResponseEntity<Object> handleCredentialsUnauthorizedException(CredentialsUnauthorizedException ex) {
        String errorMessage = ex.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(errorMessage, status);
    }
}