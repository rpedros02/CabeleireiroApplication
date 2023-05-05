package com.company.models;

import com.company.exceptions.ElementoNaoExisteException;
import com.company.repository.FilesOperation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ServicosContainer implements Serializable {

    private ArrayList<Servico> servicos;


    public ServicosContainer() {
        this.servicos = new ArrayList<>();
    }

    public ServicosContainer(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public ServicosContainer getServicosADecorrer() {
        ArrayList<Servico> servicosADecorrer = new ArrayList<Servico>();
        for (Servico servico : servicos) {
            if (servico.aDecorrer) {
                servicosADecorrer.add(servico);
            }
        }
        return new ServicosContainer(servicosADecorrer);
    }

    public void add(Servico arg) {
        this.servicos.add(new Servico(getNewNumber(), arg.getNumCliente(), arg.getNumFuncionario(), arg.getDataServico(), arg.getHorarioServico()));
    }

    public Servico search(int id) {
        Servico servico;
        for (Servico value : this.servicos) {
            servico = value;
            if (servico.getNumPedido() == id) {
                return servico;
            }
        }
        return null;
    }
    public Servico searchByCliente(int id) {
        Servico servico;
        for (Servico value : this.servicos) {
            servico = value;
            if (servico.getNumCliente() == id) {
                return servico;
            }
        }
        return null;
    }

    private long getNewNumber() {
        long num = 0;
        for (int i = servicos.size() - 1; i >= 0; i--) {
            if (servicos.get(i).getNumPedido() > num) {
                num = servicos.get(i).getNumPedido();
            }
        }
        return (num + 1);
    }

    public void update(int numPedido, long numCliente, Date dataServico, HorarioServico horarioServico) {
        Servico servico = search(numPedido);
        if (servico != null) {
            servico.setNumCliente(numCliente);
            servico.setDataServico(dataServico);
            servico.setHorarioServico(horarioServico);
        } else {
            throw new ElementoNaoExisteException("Servico " + numPedido + " não existe.");
        }
    }

    public void remove(int number) {
        Servico servico = search(number);
        if (servico != null) {
            this.servicos.remove(servico);
        } else {
            throw new ElementoNaoExisteException("Erro.");
        }
    }
}
