package com.company.exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String s) {
        super(s);
    }
}