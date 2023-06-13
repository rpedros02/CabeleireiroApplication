package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "cabeleireiro")
public class CabeleireiroDto {
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    public CabeleireiroDto(){

    }

    public CabeleireiroDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
