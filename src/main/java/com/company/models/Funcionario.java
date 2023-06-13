package com.company.models;


import com.company.exceptions.NumeroInvalidoException;

import java.io.Serializable;


public class Funcionario extends Pessoa implements Serializable {
    private int numeroFuncionario;

    public Funcionario(String nome, Date dataNascimento, int nIF, int numeroFuncionario) {
        super(nome, dataNascimento, nIF);
        if (validNumber(numeroFuncionario)) {
            this.numeroFuncionario = numeroFuncionario;
        } else {
            throw new NumeroInvalidoException("Número : " + numeroFuncionario + " Inválido.");
        }
    }

    public Funcionario(int numeroFuncionario, String nome) {
        super(nome);
        this.numeroFuncionario = numeroFuncionario;
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumFuncionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    private boolean validNumber(int numeroFuncionario) {
        return numeroFuncionario>0&&numeroFuncionario<=9999;
    }
}
