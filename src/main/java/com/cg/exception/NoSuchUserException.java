package com.cg.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoSuchUserException extends Exception {

    private String message;

    public NoSuchUserException(String message){
        super(message);
    }
}
