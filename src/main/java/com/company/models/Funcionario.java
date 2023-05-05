package com.company.models;

import com.company.enums.Genero;
import com.company.exceptions.NumeroInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Funcionário que herda os atributos da classe Pessoa e identifica o Funcionário através do Número de Funcionario.
 */
public class Funcionario extends Pessoa implements Serializable {
    private long numFuncionario;

    /**
     * Construtor do Funcionário que recebe todos os parâmetros necessários na criação de um funcionário.
     *
     * @param nome           → Nome do Funcionário - String
     * @param dataNascimento → Data de Nascimento do Funcionário - {@link Date}
     * @param nIF            → NIF do Funcionário - Int
     * @param genero         → Género do Funcionário - {@link Genero}
     * @param numFuncionario → Número de Funcionário - Long
     */
    public Funcionario(String nome, Date dataNascimento, int nIF, Genero genero, long numFuncionario) {
        super(nome, dataNascimento, nIF, genero);
        if (validNumber(numFuncionario)) {
            this.numFuncionario = numFuncionario;
        } else {
            throw new NumeroInvalidoException("Número : " + numFuncionario + " Inválido.");
        }
    }

    public Funcionario(long numFuncionario, String nome) {
        super(nome);
        this.numFuncionario = numFuncionario;
    }


    /**
     * Retorna o número do Funcionário
     *
     * @return Número do Funcionário
     */
    public long getNumFuncionario() {
        return numFuncionario;
    }

    /**
     * Define o número do Funcionário
     *
     * @param numFuncionario → Número do Funcionário
     */
    public void setNumFuncionario(long numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    /**
     * Verifica se o Número do Funcionário é válido.
     *
     * @param number Número a verificar - Long
     * @return true se a condição se verificar, caso contrário, false
     */
    private boolean validNumber(long number) {
        return number >= 0 && number <= 9999;
    }

}
