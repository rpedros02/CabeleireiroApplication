package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numeroCliente","nome","dataNascimento","nif"})
@JacksonXmlRootElement(localName = "cliente")
public class ClienteDto {
    @JacksonXmlProperty(localName = "numeroCliente")
    private int numeroCliente;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "dataNascimento")
    private DateDto dataNascimento;
    @JacksonXmlProperty(localName = "nif")
    private int nif;

    public ClienteDto(int numeroCliente, String nome, DateDto dataNascimento, int nif) {
        this.numeroCliente = numeroCliente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nif = nif;
    }
    public ClienteDto() {

    }
    public int getNumeroCliente() {
        return numeroCliente;
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
