package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numeroPedido","numeroCliente","numeroFuncionario","dataServico","horarioServico"})
@JacksonXmlRootElement(localName = "servico")
public class ServicoDto {
    @JacksonXmlProperty(localName = "numeroPedido")
    private int numeroPedido;
    @JacksonXmlProperty(localName = "numeroCliente")
    private int numeroCliente;
    @JacksonXmlProperty(localName = "numeroFuncionario")
    private int numeroFuncionario;
    @JacksonXmlProperty(localName = "dataServico")
    DateDto dataServico;
    @JacksonXmlProperty(localName = "horarioServico")
    HorarioServicoDto horarioServico;

    public ServicoDto(int numeroPedido, int numeroCliente, int numeroFuncionario, DateDto dataServico, HorarioServicoDto horarioServico) {
        this.numeroPedido = numeroPedido;
        this.numeroCliente = numeroCliente;
        this.numeroFuncionario = numeroFuncionario;
        this.dataServico = dataServico;
        this.horarioServico = horarioServico;
    }

    public ServicoDto() {
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public DateDto getDataServico() {
        return dataServico;
    }

    public HorarioServicoDto getHorarioServico() {
        return horarioServico;
    }
}
