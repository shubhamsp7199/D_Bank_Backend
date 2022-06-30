package com.cg.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateCustomerException extends Exception {

    private String message;

    public DuplicateCustomerException(String message) {
        super(message);
    }
}
