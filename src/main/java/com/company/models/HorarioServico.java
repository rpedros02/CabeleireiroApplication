package com.company.models;

import com.company.exceptions.HorarioInvalidoException;

import java.io.Serializable;

public class HorarioServico implements Serializable {
    private int hora;
    private int minutos;


    public HorarioServico(int hora, int minutos) {
        validarHorario(hora, minutos);
        this.hora = hora;
        this.minutos = minutos;

    }

    private void validarHorario(int hora, int minutos) {
        if ((hora < 0 || hora > 23)) {
            throw new HorarioInvalidoException("Hora inválida.Tente novamente:\n");
        }
        if ((minutos < 0 || minutos > 59)) {
            throw new HorarioInvalidoException("Minutos inválidos.Tente novamente:\n");
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }


    @Override
    public String toString() {
        return String.format("Hora:\t%d:%d", hora, minutos);
    }
}
