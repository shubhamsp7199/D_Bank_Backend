package com.cg.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidLoginCredentialException extends Exception {

    private String message;

    public InvalidLoginCredentialException(String message){
        super(message);
    }
}
