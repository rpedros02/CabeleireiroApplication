package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"numeroCliente","avaliacao"})
@JacksonXmlRootElement(localName = "critica")
public class CriticaListItemDto {
    @JacksonXmlProperty(localName = "numeroCliente")
    private int numeroCliente;
   @JacksonXmlProperty(localName = "avaliacao")
    private int avaliacao;

    public CriticaListItemDto() {

    }
public CriticaListItemDto(int numeroCliente, int avaliacao){
        this.avaliacao=avaliacao;
        this.numeroCliente=numeroCliente;
}

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}
