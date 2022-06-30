package com.cg.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<Object>handleDuplicateUserException(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This User is Already available.");
        return new ResponseEntity<Object>("This User is Already available.", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidLoginCredentialException.class)
    public ResponseEntity<Object>handleInvalidLoginCredentialException(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Invalid Login Credential.");
        return new ResponseEntity<Object>("Invalid Login Credential.", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<Object> handleNoSuchUserException(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This User is not present.");
        return new ResponseEntity<Object>("This User is not present.", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateCustomerException.class)
    public ResponseEntity<Object>handleDuplicateCustomerException(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This Customer is Already available.");
        return new ResponseEntity<Object>("This Customer is Already available.", headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchCustomerException.class)
    public ResponseEntity<Object>handleNoSuchCustomerException(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "No Such Customer found.");
        return new ResponseEntity<Object>("No Such Customer found.", headers, HttpStatus.BAD_REQUEST);
    }
}
