package com.company.exceptions;

public class ElementoNaoExisteException extends RuntimeException{
    public ElementoNaoExisteException(String s){
        super(s);
    }
}
