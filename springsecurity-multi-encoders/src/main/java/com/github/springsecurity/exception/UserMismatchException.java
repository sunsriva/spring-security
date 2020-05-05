package com.github.springsecurity.exception;

public class UserMismatchException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserMismatchException(String msg) {
        super(msg);
    }
}
