package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "funcionarios")
public class FuncionarioListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "funcionario")
    private ArrayList<FuncionarioListItemDto> funcionarios;

    public FuncionarioListDto(){

    }
    public FuncionarioListDto(ArrayList<FuncionarioListItemDto> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<FuncionarioListItemDto> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<FuncionarioListItemDto> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
