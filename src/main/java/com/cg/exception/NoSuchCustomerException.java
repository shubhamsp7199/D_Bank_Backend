package com.cg.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoSuchCustomerException extends Exception{

    private String message;

    public NoSuchCustomerException(String message) {
        super(message);
    }
}
