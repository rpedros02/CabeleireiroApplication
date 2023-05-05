package com.company.models;

import com.company.enums.Genero;

import java.io.Serializable;

/**
 * Classe abstrata Pessoa que apenas poderá ser instânciada como Cliente, Funcionário.
 * Identificada pelo Nome.
 */
public class Pessoa implements Serializable {
    private String nome;
    private Date dataNascimento;
    private int nIF;
    private Genero genero;
    protected Pessoa() {
    }

    /**
     * Construtor da Pessoa
     *
     * @param nome           → Nome da Pessoa - String
     * @param dataNascimento → Data de Nascimento da Pessoa - Date
     * @param nIF            → NIF da Pessoa - int
     * @param genero         → Género da Pessoa - ENUM Género
     */
    protected Pessoa(String nome, Date dataNascimento, int nIF, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nIF = nIF;
        this.genero = genero;
    }
    public Pessoa(String nome){
        this.nome = nome;
    }
    public Pessoa(String nome, Date dataNascimento, int nIF, String genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nIF = nIF;
        if(genero.equalsIgnoreCase("masculino")){
            this.genero = Genero.MASCULINO;
        } else if (genero.equalsIgnoreCase("feminino")) {
            this.genero = Genero.FEMININO;
        }else{
            this.genero = Genero.NAOBINARIO;
        }
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
    public void setNome(String nome) {
        this.nome = nome;
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

    /**
     * Retorna o Género da Pessoa
     *
     * @return Genero da Pessoa
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Define o Género da Pessoa
     *
     * @param genero Género da Pessoa
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
