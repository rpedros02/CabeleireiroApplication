package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "criticas")
public class CriticaListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "critica")
    private ArrayList<CriticaListItemDto> criticas;

    public CriticaListDto(){
    }
    public CriticaListDto(ArrayList<CriticaListItemDto> criticas) {
        this.criticas = criticas;
    }


    public ArrayList<CriticaListItemDto> getCriticas() {
        return criticas;
    }

    public void setCriticas(ArrayList<CriticaListItemDto> criticas) {
        this.criticas = criticas;
    }
}