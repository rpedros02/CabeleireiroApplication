package com.company.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numeroFuncionario","nome"})
@JacksonXmlRootElement(localName = "funcionario")
public class FuncionarioListItemDto {
    @JacksonXmlProperty(localName = "numeroFuncionario")
    private int numeroFuncionario;
    @JacksonXmlProperty(localName = "nome")
    private String nome;

    public FuncionarioListItemDto() {
    }
    public FuncionarioListItemDto(int numeroFuncionario, String nome) {
        this.nome=nome;
        this.numeroFuncionario=numeroFuncionario;
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
