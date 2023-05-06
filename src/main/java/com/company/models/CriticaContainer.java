package com.company.models;

import java.io.Serializable;
import java.util.ArrayList;

public class CriticaContainer implements Serializable{
    private ArrayList<Critica> criticas;
    public CriticaContainer() {
        this.criticas = new ArrayList<>();
    }

    public CriticaContainer(ArrayList<Critica> criticas) {
        this.criticas = criticas;
    }

    public ArrayList<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(ArrayList<Critica> criticas) {
        this.criticas = criticas;
    }

    public Critica search(long id) {
        Critica critica;
        for (Critica value : this.criticas) {
            critica = value;
            if (critica.getCliente() == id) {
                return critica;
            }
        }
        return null;
    }

    public void add(Critica obj) {
        this.criticas.add(new Critica(obj.getCliente(),obj.getAvaliacao(),obj.getTexto(),obj.getDataCritica()));
    }
}
