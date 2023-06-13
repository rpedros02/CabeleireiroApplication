package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "servicos")
public class ServicoListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "servico")
    private ArrayList<ServicoListItemDto> servicos;

    public ServicoListDto(ArrayList<ServicoListItemDto> servicos) {
        this.servicos = servicos;
    }

    public ArrayList<ServicoListItemDto> getServicos() {
        return servicos;
    }
}

