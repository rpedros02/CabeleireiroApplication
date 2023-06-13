package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numeroCliente","avaliacao", "texto", "dataCritica"})
@JacksonXmlRootElement(localName = "critica")
public class CriticaDto {
    @JacksonXmlProperty(localName = "numeroCliente")
    private int numeroCliente;
    @JacksonXmlProperty(localName = "avaliacao")
    private int avaliacao;
    @JacksonXmlProperty(localName = "texto")
    private String texto;
    @JacksonXmlProperty(localName = "dataCritica")
    DateDto dataCritica;


    public CriticaDto(int numeroCliente, int avaliacao, String texto, DateDto dataCritica) {
        this.numeroCliente = numeroCliente;
        this.avaliacao = avaliacao;
        this.texto = texto;
        this.dataCritica = dataCritica;
    }

    public CriticaDto() {
      }

    public int getAvaliacao() {
        return avaliacao;
    }

    public String getTexto() {
        return texto;
    }

    public DateDto getDataCritica() {
        return dataCritica;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }
}
