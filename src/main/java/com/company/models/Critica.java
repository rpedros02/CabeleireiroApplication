package com.company.models;

import com.company.exceptions.CriticaInvalidaException;

import java.io.Serializable;

/**
 * Classe Referente a uma crítica efetuada por um Cliente.
 */
public class Critica implements Serializable {
    private Cliente cliente;
    private int avaliacao;
    private String texto;
    private Date dataCritica;

    /**
     * Construtor da Crítica.
     *
     * @param cliente → Cliente que efetuou a Crítica - {@link Cliente}.
     * @param avaliacao → Avaliação (0/10) - {@link Critica#validarAvaliacao()}.
     * @param texto → Texto da crítica - {@link }.
     * @param dataCritica → Data da Crítica - {@link Date}.
     */
    public Critica(Cliente cliente, int avaliacao, String texto, Date dataCritica) {
        this.cliente = cliente;
        if(validarAvaliacao()){
            this.avaliacao = avaliacao;
        }else{
            throw new CriticaInvalidaException("Erro: " + avaliacao + " - Avaliação Inválida");
        }
        if(validarTexto()){
            this.texto = texto;
        }else{
            throw new CriticaInvalidaException("Erro: " + texto.length() + " - Tamanho de Texto Inválido");
        }
        this.dataCritica = dataCritica;
    }
    public Critica(long numcliente, int avaliacao, String texto, Date dataCritica) {
        this.cliente = new Cliente(numcliente);
        if(validarAvaliacao()){
            this.avaliacao = avaliacao;
        }else{
            throw new CriticaInvalidaException("Erro: " + avaliacao + " - Avaliação Inválida");
        }
        if(validarTexto()){
            this.texto = texto;
        }else{
            throw new CriticaInvalidaException("Erro: " + texto.length() + " - Tamanho de Texto Inválido");
        }
        this.dataCritica = dataCritica;
    }

    /**
     * Método que valida a avaliação (0/10).
     *
     * @return true se a avaliacao for entre os parâmetros, falso caso contrário.
     */
    public boolean validarAvaliacao(){
        return avaliacao >= 0 && avaliacao <= 10;
    }
    /**
     * Método que valida o Texto (entre 50 e 255 caratéres).
     *
     * @return true se a avaliacao for entre os parâmetros, falso caso contrário.
     */
    public boolean validarTexto(){
        return texto.length() > 50 && texto.length() <= 255;
    }

    public Cliente getCliente() {
        return cliente;
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
