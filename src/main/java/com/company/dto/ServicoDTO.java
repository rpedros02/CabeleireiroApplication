package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"numPedido","numCliente","dataServico","horarioServico"})
@JacksonXmlRootElement(localName = "servico")
public class ServicoDTO {
    @JacksonXmlProperty(localName = "numPedido")
    private long numPedido;
    @JacksonXmlProperty(localName = "numCliente")
    private long numCliente;
    @JacksonXmlProperty(localName = "dataServico")
    private DateDTO dataServico;
    @JacksonXmlProperty(localName = "horarioServico")
    private HorarioServicoDTO horarioServico;


    public ServicoDTO(long numPedido, long numCliente, DateDTO dataServico, HorarioServicoDTO horarioServico) {
        this.numPedido = numPedido;
        this.numCliente = numCliente;
        this.dataServico = dataServico;
        this.horarioServico = horarioServico;
    }

    public ServicoDTO(){
        this.numPedido = getNumPedido();
        this.numCliente = getNumCliente();
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
}
