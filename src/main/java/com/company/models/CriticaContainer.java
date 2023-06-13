package com.company.models;

import com.company.exceptions.InvalidDateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CriticaContainer implements Serializable{
    private ArrayList<Critica> criticas;
    public CriticaContainer() {
        this.criticas = new ArrayList<>();
    }

    public CriticaContainer(ArrayList<Critica> criticas) {
        this.criticas = criticas;
    }

    public List<Critica> getAll(){
        List<Critica> newlist = new ArrayList();
        newlist.addAll(this.criticas);
        return newlist;
    }
    public Critica get(int id){
        Critica critica = search(id);
        if(critica != null){
            return critica;
        }else{
            String msg = "Critica: " + id+ " nao existe!!";
            throw  new InvalidDateException(msg);
        }
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
