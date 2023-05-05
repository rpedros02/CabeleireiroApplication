package com.company.models;

import com.company.enums.Genero;

import java.io.Serializable;

/**
 * Classe Cliente que herda os atributos da classe Pessoa e identifica o Cliente através do Número de Cliente.
 */
public class Cliente extends Pessoa implements Serializable {
    private long numeroCliente;

    public Cliente(long numeroCliente) {
        super();
        this.numeroCliente = numeroCliente;
    }
    public Cliente(long numeroCliente, String nome) {
        super(nome);
        this.numeroCliente = numeroCliente;
    }


    /**
     * Construtor do Cliente que recebe todos os parâmetros necessários na criação de um cliente.
     *
     * @param nome           → Nome do Cliente - String
     * @param dataNascimento → Data de Nascimento do Cliente - {@link Date}
     * @param nIF            → NIF do Cliente - Int
     * @param genero         → Género do Cliente - {@link Genero}
     * @param numeroCliente  → Número de Cliente - Long
     */
    public Cliente(String nome, Date dataNascimento, int nIF, Genero genero, long numeroCliente) {
        super(nome, dataNascimento, nIF, genero);
        this.numeroCliente = numeroCliente;
    }
    public Cliente(String nome, Date dataNascimento, int nIF, String genero, long numeroCliente) {
        super(nome, dataNascimento, nIF, genero);
        this.numeroCliente = numeroCliente;
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
}
