package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "criticas")
public class CriticaListDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "critica")
    private ArrayList<CriticaDTO> criticas;


    public CriticaListDTO(ArrayList<CriticaDTO> criticas) {
        this.criticas = criticas;
    }

    public ArrayList<CriticaDTO> getCriticas() {
        return criticas;
    }
}