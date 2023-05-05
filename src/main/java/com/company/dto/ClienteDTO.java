package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numCliente","nome","dataNascimento","nif","genero"})
@JacksonXmlRootElement(localName = "cliente")
public class ClienteDTO {
    @JacksonXmlProperty(localName = "numCliente")
    private long numeroCliente;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "dataNascimento")
    private DateDTO dataNascimento;
    @JacksonXmlProperty(localName = "nif")
    private int nif;
    @JacksonXmlProperty(localName = "genero")
    private String genero;

    public ClienteDTO(long numeroCliente,String nome,DateDTO dataNascimento,int nif,String genero) {
        this.numeroCliente = numeroCliente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nif = nif;
        this.genero = genero;
    }
    public ClienteDTO() {
        this.numeroCliente = getNumeroCliente();
        this.nome = getNome();
        this.dataNascimento = getDataNascimento();
        this.nif = getNif();
        this.genero = getGenero();
    }
    public long getNumeroCliente() {
        return numeroCliente;
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
