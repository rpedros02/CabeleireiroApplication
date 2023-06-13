package com.company.models;

import com.company.exceptions.ElementoNaoExisteException;
import com.company.exceptions.InvalidDateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServicosContainer implements Serializable {

    private ArrayList<Servico> servicos;


    public ServicosContainer() {
        this.servicos = new ArrayList<>();
    }

    public ServicosContainer(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Servico> getAll(){
        List<Servico> newlist = new ArrayList();
        newlist.addAll(this.servicos);
        return newlist;
    }
    public Servico get(int number){
        Servico servico = search(number);
        if(servico != null){
            return servico;
        }else{
            String msg = "Servico: " + number+ " nao existe!!";
            throw  new InvalidDateException(msg);
        }
    }

    public void add(Servico arg) {
        this.servicos.add(new Servico(getNewNumber(),arg.getNumeroCliente(),arg.getNumeroFuncionario(), arg.getDataServico(), arg.getHorarioServico()));
    }

    public Servico search(int id) {
        Servico servico;
        for (Servico value : this.servicos) {
            servico = value;
            if (servico.getNumeroPedido() == id) {
                return servico;
            }
        }
        return null;
    }
    public Servico searchByCliente(int id) {
        Servico servico;
        for (Servico value : this.servicos) {
            servico = value;
            if (servico.getNumeroCliente() == id) {
                return servico;
            }
        }
        return null;
    }

    private int getNewNumber() {
        int num = 0;
        for (int i = servicos.size() - 1; i >= 0; i--) {
            if (servicos.get(i).getNumeroPedido() > num) {
                num = servicos.get(i).getNumeroPedido();
            }
        }
        return (num + 1);
    }

    public void update(int numeroPedido, int numeroCliente, int numeroFuncionario, Date dataServico, HorarioServico horarioServico) {
        Servico servico = search(numeroPedido);
        if (servico != null) {
            servico.setNumeroCliente(numeroCliente);
            servico.setDataServico(dataServico);
            servico.setHorarioServico(horarioServico);
            servico.setNumeroFuncionario(numeroFuncionario);
        } else {
            throw new ElementoNaoExisteException("Servico " + numeroPedido + " não existe.");
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
