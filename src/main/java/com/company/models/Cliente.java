package com.company.models;
import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private int numeroCliente;
    public Cliente(String nome, Date dataNascimento, int nIF, int numeroCliente) {
        super(nome,dataNascimento,nIF);
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
}
