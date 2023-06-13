package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "clientes")
public class ClienteListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "cliente")
    private ArrayList<ClienteListItemDto> clientes;

    public ClienteListDto(){

    }

    public ClienteListDto(ArrayList<ClienteListItemDto> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<ClienteListItemDto> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<ClienteListItemDto> clientes) {
        this.clientes = clientes;
    }
}
