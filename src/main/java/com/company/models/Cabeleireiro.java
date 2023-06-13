package com.company.models;

import com.company.repository.FilesOperation;

import java.io.Serializable;
import java.util.ArrayList;

public class Cabeleireiro implements Serializable {
    private String nome;
    private String morada;
    private double saldo;
    private int numCadeirasLavagem;
    private int numCadeirasBrushing;
    private Horario horario;
    public ServicosContainer servicos;
    private FuncionarioContainer funcionarios;
    private ClienteContainer clientes;
    private ProdutoContainer produtos;
    private CriticaContainer criticas;


    public Cabeleireiro() {
        this.nome ="Undefined";
        this.servicos = new ServicosContainer();
        this.funcionarios = new FuncionarioContainer();
        this.clientes = new ClienteContainer();
        this.produtos = new ProdutoContainer();
        this.criticas = new CriticaContainer();
    }

    public Cabeleireiro(String nome, String morada, double saldo, int numCadeirasLavagem, int numCadeirasBrushing, Horario horario, ServicosContainer servicos, FuncionarioContainer funcionarios, ClienteContainer clientes, ProdutoContainer produtos, CriticaContainer criticas) {
        this.nome = nome;
        this.morada = morada;
        this.saldo = saldo;
        this.numCadeirasLavagem = numCadeirasLavagem;
        this.numCadeirasBrushing = numCadeirasBrushing;
        this.horario = horario;
        this.servicos = servicos;
        this.funcionarios = funcionarios;
        this.clientes = clientes;
        this.produtos = produtos;
        this.criticas = criticas;
    }

    public Cabeleireiro(String nome, String morada, double saldo, int numCadeirasLavagem, int numCadeirasBrushing) {
        this.nome = nome;
        this.morada = morada;
        this.saldo = saldo;
        this.numCadeirasLavagem = numCadeirasLavagem;
        this.numCadeirasBrushing = numCadeirasBrushing;
        this.servicos = new ServicosContainer();
        this.funcionarios = new FuncionarioContainer();
        this.clientes = new ClienteContainer();
        this.produtos = new ProdutoContainer();
        this.criticas = new CriticaContainer();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumCadeirasLavagem() {
        return numCadeirasLavagem;
    }

    public int getNumCadeirasBrushing() {
        return numCadeirasBrushing;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public FuncionarioContainer getFuncionarios() {
        return funcionarios;
    }

    public ClienteContainer getClientes() {
        return clientes;
    }

    public ProdutoContainer getProdutos() {
        return produtos;
    }

    public ServicosContainer getServicos() {
        return servicos;
    }

    public CriticaContainer getCriticas() {
        return criticas;
    }
}
