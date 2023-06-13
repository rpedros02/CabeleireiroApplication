package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"horaAbertura", "minutoAbertura", "horaFecho", "minutoFecho"})
@JacksonXmlRootElement(localName = "horario")
public class HorarioDto {
    @JacksonXmlProperty(localName = "horaAbertura")
    private int horaAbertura;
    @JacksonXmlProperty(localName = "minutoAbertura")
    private int minutoAbertura;
    @JacksonXmlProperty(localName = "horaFecho")
    private int horaFecho;
    @JacksonXmlProperty(localName = "minutoFecho")
    private int minutoFecho;


    public HorarioDto(int horaAbertura, int minutoAbertura, int horaFecho, int minutoFecho) {
        this.horaAbertura = horaAbertura;
        this.minutoAbertura = minutoAbertura;
        this.horaFecho = horaFecho;
        this.minutoFecho = minutoFecho;
    }
    public HorarioDto() {
        this.horaAbertura = getHoraAbertura();
        this.minutoAbertura = getMinutoAbertura();
        this.horaFecho = getHoraFecho();
        this.minutoFecho = getMinutoFecho();
    }
    public int getHoraAbertura() {
        return horaAbertura;
    }

    public int getMinutoAbertura() {
        return minutoAbertura;
    }

    public int getHoraFecho() {
        return horaFecho;
    }

    public int getMinutoFecho() {
        return minutoFecho;
    }
}
