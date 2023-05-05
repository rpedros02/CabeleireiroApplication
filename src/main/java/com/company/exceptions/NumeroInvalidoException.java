package com.company.exceptions;

/**
 * Exceção Referente aos Números de Funcionário ou Cliente
 */
public class NumeroInvalidoException extends RuntimeException {
    public NumeroInvalidoException(String s) {
        super(s);
    }
}
