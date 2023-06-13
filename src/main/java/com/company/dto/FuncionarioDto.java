package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numeroFuncionario","nome","dataNascimento","nif"})
@JacksonXmlRootElement(localName = "funcionario")
public class FuncionarioDto {
    @JacksonXmlProperty(localName = "numeroFuncionario")
    private int numeroFuncionario;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "dataNascimento")
    private DateDto dataNascimento;
    @JacksonXmlProperty(localName = "nif")
    private int nif;
    public FuncionarioDto(int numeroFuncionario, String nome, DateDto dataNascimento, int nif) {
        this.numeroFuncionario = numeroFuncionario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nif = nif;
    }

    public FuncionarioDto(){
         }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public DateDto getDataNascimento() {
        return dataNascimento;
    }

    public int getNif() {
        return nif;
    }
}
