package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numPedido","numCliente","numFuncionario","dataServico","horarioServico"})
@JacksonXmlRootElement(localName = "servico")
public class ServicoDTO {
    @JacksonXmlProperty(localName = "numPedido")
    private long numPedido;
    @JacksonXmlProperty(localName = "numCliente")
    private long numCliente;
    @JacksonXmlProperty(localName = "numFuncionario")
    private long numFuncionario;
    @JacksonXmlProperty(localName = "dataServico")
    private DateDTO dataServico;
    @JacksonXmlProperty(localName = "horarioServico")
    private HorarioServicoDTO horarioServico;


    public ServicoDTO(long numPedido, long numCliente, long numFuncionario, DateDTO dataServico, HorarioServicoDTO horarioServico) {
        this.numPedido = numPedido;
        this.numCliente = numCliente;
        this.numFuncionario = numFuncionario;
        this.dataServico = dataServico;
        this.horarioServico = horarioServico;
    }

    public ServicoDTO(){
        this.numPedido = getNumPedido();
        this.numCliente = getNumCliente();
        this.numFuncionario = getNumFuncionario();
        this.dataServico = getDataServico();
        this.horarioServico = getHorarioServico();
    }

    public long getNumPedido() {
        return numPedido;
    }

    public DateDTO getDataServico() {
        return dataServico;
    }

    public HorarioServicoDTO getHorarioServico() {
        return horarioServico;
    }

    public long getNumCliente() {
        return numCliente;
    }

    public long getNumFuncionario() {
        return numFuncionario;
    }
}
