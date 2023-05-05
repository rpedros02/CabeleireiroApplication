package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numeroFuncionario","nome"})
@JacksonXmlRootElement(localName = "funcionario")
public class FuncionarioDTO {
    @JacksonXmlProperty(localName = "numeroFuncionario")
    private long numeroFuncionario;
    @JacksonXmlProperty(localName = "nome")
    private String nome;

    public FuncionarioDTO(long numeroFuncionario, String nome) {
        this.numeroFuncionario = numeroFuncionario;
        this.nome = nome;
    }

    public long getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public String getNome() {
        return nome;
    }
}
