package com.company.models;


import com.company.exceptions.HorarioInvalidoException;

import java.io.Serializable;

public class Horario implements Serializable {
    private int horaAbertura;
    private int minutosAbertura;
    private int horaFecho;
    private int minutosFecho;

    public Horario(int horaAbertura, int minutosAbertura, int horaFecho, int minutosFecho) {
        validarHorario(horaAbertura, minutosAbertura, horaFecho, minutosFecho);
        this.horaAbertura = horaAbertura;
        this.minutosAbertura = minutosAbertura;
        this.horaFecho = horaFecho;
        this.minutosFecho = minutosFecho;
    }

    private void validarHorario(int horaAbertura, int minutosAbertura, int horaFecho, int minutosFecho) {
        if ((horaAbertura < 0 || horaAbertura > 23) && (horaFecho < 0 || horaFecho > 23)) {
            throw new HorarioInvalidoException("Hora inválida.Tente novamente:\n");
        }
        if ((minutosAbertura < 0 || minutosAbertura > 59) && (minutosFecho < 0 || minutosFecho > 59)) {
            throw new HorarioInvalidoException("Minutos inválidos.Tente novamente:\n");
        }
        if (horaFecho < horaAbertura) {
            throw new HorarioInvalidoException("Hora de fecho superior à hora de abertura.Tente novamente:\n");
        }
        if ((horaAbertura == horaFecho) && (minutosFecho < minutosAbertura)) {
            throw new HorarioInvalidoException("Hora de fecho superior à hora de abertura.Tente novamente:\n");
        }
        if ((horaAbertura == horaFecho) && (minutosFecho == minutosAbertura)) {
            throw new HorarioInvalidoException("Hora de fecho igual à hora de abertura.Tente novamente:\n");
        }

    }

    public int getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(int horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public int getMinutosAbertura() {
        return minutosAbertura;
    }

    public void setMinutosAbertura(int minutosAbertura) {
        this.minutosAbertura = minutosAbertura;
    }

    public int getHoraFecho() {
        return horaFecho;
    }

    public void setHoraFecho(int horaFecho) {
        this.horaFecho = horaFecho;
    }

    public int getMinutosFecho() {
        return minutosFecho;
    }

    public void setMinutosFecho(int minutosFecho) {
        this.minutosFecho = minutosFecho;
    }

    @Override
    public String toString() {
        return String.format("Abertura:\t%d:%d\nFecho:\t%d:%d", horaAbertura, minutosAbertura, horaFecho, minutosFecho);
    }
}
