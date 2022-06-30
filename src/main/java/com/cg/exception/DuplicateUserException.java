package com.cg.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateUserException extends Exception {

    private String message;

    public DuplicateUserException(String message){
        super(message);
    }
}
