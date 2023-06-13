package com.company.models;


import com.company.exceptions.ElementoNaoExisteException;
import com.company.exceptions.InvalidDateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioContainer implements Serializable {
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioContainer() {
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

    public List<Funcionario> getAll(){
        List<Funcionario> newlist = new ArrayList();
        newlist.addAll(this.funcionarios);
        return newlist;
    }
    public Funcionario get(int number){
        Funcionario funcionario = search(number);
        if(funcionario != null){
            return funcionario;
        }else{
            String msg = "Funcionario: " + number+ "nao existe!!";
            throw  new InvalidDateException(msg);
        }
    }

    public void removeFuncionario(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getNumeroFuncionario() == id);
    }

    public Funcionario search(int id) {
        Funcionario funcionario;
        for (Funcionario value : this.funcionarios) {
            funcionario = value;
            if (funcionario.getNumeroFuncionario() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void add(Funcionario obj) {
        this.funcionarios.add(new Funcionario(obj.getNome(), obj.getDataNascimento(), obj.getnIF(), getNewNumber()));
    }


    private int getNewNumber() {
        int num = 0;
        for (int i = funcionarios.size() - 1; i >= 0; i--) {
            if (funcionarios.get(i).getNumeroFuncionario() > num) {
                num = funcionarios.get(i).getNumeroFuncionario();
            }
        }
        return (num + 1);
    }

    public void update(int numeroFuncionario, Funcionario arg) {
        Funcionario funcionario = search(numeroFuncionario);
        if (funcionario != null) {
            funcionario.setNome(arg.getNome());
            funcionario.setDataNascimento(arg.getDataNascimento());
            funcionario.setnIF(arg.getnIF());
        } else {
            throw new ElementoNaoExisteException("Cliente " + numeroFuncionario + " não existe.");
        }
    }

    public void remove(int number) {
        Funcionario funcionario = search(number);
        if (funcionario != null) {
            this.funcionarios.remove(funcionario);
        } else {
            throw new ElementoNaoExisteException("Erro - Elemento não existe.");
        }
    }

}
