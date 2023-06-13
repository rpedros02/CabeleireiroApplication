package com.company.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numeroPedido","numeroFuncionario"})
@JacksonXmlRootElement(localName = "servico")
public class ServicoListItemDto {
    @JacksonXmlProperty(localName = "numeroPedido")
    private int numeroPedido;
    @JacksonXmlProperty(localName = "numeroFuncionario")
    private int numeroFuncionario;
    ServicoListItemDto(){

    }
    ServicoListItemDto(int numeroPedido, int numeroFuncionario){
    this.numeroPedido=numeroPedido;
    this.numeroFuncionario=numeroFuncionario;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }
}
