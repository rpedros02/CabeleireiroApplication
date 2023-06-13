package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"hora","minuto"})
@JacksonXmlRootElement(localName = "horarioServico")
public class HorarioServicoDto {
    @JacksonXmlProperty(localName = "hora")
    private int hora;
    @JacksonXmlProperty(localName = "minuto")
    private int minuto;

    public HorarioServicoDto(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    public HorarioServicoDto(){
        this.hora = getHora();
        this.minuto = getMinuto();
    }
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
}
