package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome", "morada", "saldo", "numCadeirasLavagem", "numeroCadeirasBrushing", "horario"})
@JacksonXmlRootElement(localName = "cabeleireiro")
public class CabeleireiroDTO {
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "morada")
    private String morada;
    @JacksonXmlProperty(localName = "saldo")
    private double saldo;
    @JacksonXmlProperty(localName = "numCadeirasLavagem")
    private int numCadeirasLavagem;
    @JacksonXmlProperty(localName = "numeroCadeirasBrushing")
    private int numCadeirasBrushing;
    @JacksonXmlProperty(localName = "horario")
    private HorarioDTO horario;

    public CabeleireiroDTO(String nome, String morada, double saldo, int numCadeirasLavagem, int numCadeirasBrushing, HorarioDTO horario) {
        this.nome = nome;
        this.morada = morada;
        this.saldo = saldo;
        this.numCadeirasLavagem = numCadeirasLavagem;
        this.numCadeirasBrushing = numCadeirasBrushing;
        this.horario = horario;
    }

    public CabeleireiroDTO(){
        this.nome = getNome();
        this.morada = getMorada();
        this.saldo = getSaldo();
        this.numCadeirasLavagem = getNumCadeirasLavagem();
        this.numCadeirasBrushing = getNumCadeirasBrushing();
        this.horario = getHorario();
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumCadeirasLavagem() {
        return numCadeirasLavagem;
    }

    public int getNumCadeirasBrushing() {
        return numCadeirasBrushing;
    }

    public HorarioDTO getHorario() {
        return horario;
    }
}
