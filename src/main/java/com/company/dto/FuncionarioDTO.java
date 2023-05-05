package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numeroFuncionario","nome","dataNascimento","nif","genero"})
@JacksonXmlRootElement(localName = "funcionario")
public class FuncionarioDTO {
    @JacksonXmlProperty(localName = "numeroFuncionario")
    private long numeroFuncionario;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "dataNascimento")
    private DateDTO dataNascimento;
    @JacksonXmlProperty(localName = "nif")
    private int nif;
    @JacksonXmlProperty(localName = "genero")
    private String genero;
    public FuncionarioDTO(long numeroFuncionario, String nome, DateDTO dataNascimento, int nif, String genero) {
        this.numeroFuncionario = numeroFuncionario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nif = nif;
        this.genero = genero;
    }

    public FuncionarioDTO(){
        this.numeroFuncionario = getNumeroFuncionario();
        this.nome = getNome();
        this.dataNascimento = getDataNascimento();
        this.nif = getNif();
    }

    public long getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public DateDTO getDataNascimento() {
        return dataNascimento;
    }

    public int getNif() {
        return nif;
    }

    public String getGenero() {
        return genero;
    }
}
