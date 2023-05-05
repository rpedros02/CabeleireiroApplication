package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "servicos")
public class ServicoListDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "servico")
    private ArrayList<ServicoDTO> servicos;

    public ServicoListDTO(ArrayList<ServicoDTO> servicos) {
        this.servicos = servicos;
    }

    public ArrayList<ServicoDTO> getServicos() {
        return servicos;
    }
}

