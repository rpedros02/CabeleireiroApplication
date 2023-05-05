package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "clientes")
public class ClienteListDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "cliente")
    private ArrayList<ClienteDTO> clientes;


    public ClienteListDTO(ArrayList<ClienteDTO> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<ClienteDTO> getClientes() {
        return clientes;
    }
}
