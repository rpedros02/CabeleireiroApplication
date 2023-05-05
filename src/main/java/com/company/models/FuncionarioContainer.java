package com.company.models;

import com.company.dto.FuncionarioDTO;
import com.company.enums.Genero;
import com.company.exceptions.ElementoNaoExisteException;

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
//INICIO ESTATISTICA
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
    public ArrayList<Pessoa> getNFuncionariosMaisNovos(int n) {
        boolean flag;
        ArrayList<Pessoa> lista = new ArrayList<>();
        if (n <= 0) {
            return lista;
        }
        for (Pessoa p : funcionarios) {
            flag = false;
            for (int i = 0; i < lista.size(); i++) {
                if (!p.getDataNascimento().isEarlier(lista.get(i).getDataNascimento())) {
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



    // FIM ESTATISTICA
    public Funcionario search(int id) {
        Funcionario funcionario;
        for (Funcionario value : this.funcionarios) {
            funcionario = value;
            if (funcionario.getNumFuncionario() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void add(Funcionario obj) {
        this.funcionarios.add(new Funcionario(obj.getNome(), obj.getDataNascimento(), obj.getnIF(), obj.getGenero(), getNewNumber()));
    }

    private long getNewNumber() {
        long num = 0;
        for (int i = funcionarios.size() - 1; i >= 0; i--) {
            if (funcionarios.get(i).getNumFuncionario() > num) {
                num = funcionarios.get(i).getNumFuncionario();
            }
        }
        return (num + 1);
    }

    public void update(int numFuncionario, Funcionario arg) {
        Funcionario funcionario = search(numFuncionario);
        if (funcionario != null) {
            funcionario.setNome(arg.getNome());
            funcionario.setDataNascimento(arg.getDataNascimento());
            funcionario.setnIF(arg.getnIF());
            funcionario.setGenero(arg.getGenero());
        } else {
            throw new ElementoNaoExisteException("Cliente " + numFuncionario + " não existe.");
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
