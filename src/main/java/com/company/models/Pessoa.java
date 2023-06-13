package com.company.models;

import com.company.exceptions.InvalidDateException;

import java.io.Serializable;

/**
 * Classe abstrata Pessoa que apenas poderá ser instânciada como Cliente, Funcionário.
 * Identificada pelo Nome.
 */
public class Pessoa implements Serializable {
    private String nome;
    private Date dataNascimento;
    private int nIF;
    private boolean isNameValid(String nome){
        return nome.length() >= 3;
    }
    protected Pessoa() {
    }
    public Pessoa(String nome){
        setNome(nome);
    }
    public Pessoa(String nome, Date dataNascimento, int nIF) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nIF = nIF;
    }

    /**
     * Dá return do nome da Pessoa
     *
     * @return Nome da Pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da Pessoa
     *
     * @param nome Nome da Pessoa
     */
    public void setNome(String nome){
        if(isNameValid(nome)){
            this.nome = nome;
        }else{

            String msg = "Person: " + nome;
            throw new InvalidDateException(msg);
        }
    }

    /**
     * Retorna a data de nascimento da Pessoa
     *
     * @return Data de Nascimento da Pessoa
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento da Pessoa
     *
     * @param dataNascimento Data de Nascimento da Pessoa
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna o NIF da Pessoa
     *
     * @return NIF da Pessoa
     */
    public int getnIF() {
        return nIF;
    }

    /**
     * Define o NIF da Pessoa
     *
     * @param nIF NIF da Pessoa
     */
    public void setnIF(int nIF) {
        this.nIF = nIF;
    }

}
