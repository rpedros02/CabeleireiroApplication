package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numeroCliente","avaliacao","texto","dataCritica"})
@JacksonXmlRootElement(localName = "critica")
public class CriticaDTO {
    @JacksonXmlProperty(localName = "numeroCliente")
    private long numeroCliente;
    @JacksonXmlProperty(localName = "avaliacao")
    private int avaliacao;
    @JacksonXmlProperty(localName = "texto")
    private String texto;
    @JacksonXmlProperty(localName = "dataCritica")
    DateDTO dataCritica;


    public CriticaDTO(long numeroCliente, int avaliacao, String texto, DateDTO dataCritica) {
        this.numeroCliente = numeroCliente;
        this.avaliacao = avaliacao;
        this.texto = texto;
        this.dataCritica = dataCritica;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public String getTexto() {
        return texto;
    }
    public DateDTO getDataCritica() {
        return dataCritica;
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }
}
