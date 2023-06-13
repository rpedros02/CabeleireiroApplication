package com.company.models;

import com.company.exceptions.CriticaInvalidaException;
import com.company.repository.FilesOperation;

import java.io.Serializable;

public class Critica implements Serializable {
    private int numeroCliente;
    private int avaliacao;
    private String texto;
    private Date dataCritica;

    public Critica(int numeroCliente, int avaliacao, String texto, Date dataCritica) {
        this.numeroCliente = numeroCliente;
        if (validarAvaliacao()) {
            this.avaliacao = avaliacao;
        } else {
            throw new CriticaInvalidaException("Erro: " + avaliacao + " - Avaliação Inválida");
        }
        this.texto = texto;
       /* if (!validarTexto()) {
            throw new CriticaInvalidaException("Erro: " + texto.length() + " - Tamanho de Texto Inválido");
        }*/
        this.dataCritica = dataCritica;
    }

    public boolean validarAvaliacao() {
        return avaliacao >= 0 && avaliacao <= 10;
    }

    public boolean validarTexto() {
        return getTexto().split(" ").length > 50 && getTexto().split(" ").length <= 255;
    }

    public int getCliente() {
        return numeroCliente;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public String getTexto() {
        return texto;
    }

    public Date getDataCritica() {
        return dataCritica;
    }
}
