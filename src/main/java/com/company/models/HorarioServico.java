package com.company.models;

import com.company.exceptions.HorarioInvalidoException;

import java.io.Serializable;


public class HorarioServico implements Serializable {
    private int hora;
    private int minuto;

    public HorarioServico(int hora, int minutos) {
        validarHorario(hora, minuto);
        this.hora = hora;
        this.minuto = minutos;

    }

    private void validarHorario(int hora, int minuto) {
        if ((hora < 0 || hora > 23)) {
            throw new HorarioInvalidoException("Hora inválida.Tente novamente:\n");
        }
        if ((minuto < 0 || minuto > 59)) {
            throw new HorarioInvalidoException("Minutos inválidos.Tente novamente:\n");
        }
    }
    public void getHorario(int [] Hm) {
        Hm[0] = this.minuto;
        Hm[1] = this.hora;

    };
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minuto;
    }

    public void setMinutos(int minuto) {
        this.minuto = minuto;
    }

/*
    @Override
    public String toString() {
        return String.format("Hora:\t%d:%d", hora, minuto);
    }
*/
}
