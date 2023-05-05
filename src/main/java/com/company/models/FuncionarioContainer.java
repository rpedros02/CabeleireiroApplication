package com.company.models;

import java.io.Serializable;
import java.util.ArrayList;

public class FuncionarioContainer implements Serializable {
    private ArrayList<Funcionario> funcionarios;

    protected FuncionarioContainer() {
        this.funcionarios = new ArrayList<>();
    }

    public FuncionarioContainer(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario arg) {
        funcionarios.add(arg);
    }

    public void removeFuncionario(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getNumFuncionario() == id);
    }

    public ArrayList<Pessoa> getNFuncionariosMaisVelhos(int n) {
        boolean flag;
        ArrayList<Pessoa> lista = new ArrayList<>();
        if (n <= 0) {
            return lista;
        }
        for (Pessoa p : funcionarios) {
            flag = false;
            for (int i = 0; i < lista.size(); i++) {
                if (p.getDataNascimento().isEarlier(lista.get(i).getDataNascimento())) {
                    lista.add(i, p);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                lista.add(p);
            }
        }

        if (lista.size() > n) {
            lista.subList(n, lista.size()).clear();
        }

        return lista;
    }

}
