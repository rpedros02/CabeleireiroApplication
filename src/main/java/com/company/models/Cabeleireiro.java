package com.company.models;

import com.company.repository.FilesOperation;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.io.Serializable;
import java.util.ArrayList;

public class Cabeleireiro implements Serializable {
    private String nome;
    private String morada;
    private double saldo;
    private int numCadeirasLavagem;
    private int numCadeirasBrushing;
    private Horario horario;
    private ServicosContainer servicosADecorrer;
    public ServicosContainer servicos;
    private FuncionarioContainer funcionarios;
    private ClienteContainer clientes;
    private ProdutoContainer produtos;
    private CriticaContainer criticas;


    /**
     * Construtor do Cabeleireiro.
     *
     * @param nome                → Nome do Cabeleireiro - String
     * @param morada              → Morada do Cabeleireiro - String
     * @param saldo               → Saldo de caixa do Cabeleireiro - Double
     * @param numCadeirasLavagem  → Número de Cadeiras de Lavagem - Int
     * @param numCadeirasBrushing → Número de Cadeiras de Brushing - Int
     * @param horario             → Horário do Cabeleireiro - {@link Horario}
     */
    public Cabeleireiro(String nome, String morada, double saldo, int numCadeirasLavagem, int numCadeirasBrushing, Horario horario) {
        this.nome = nome;
        this.morada = morada;
        this.saldo = saldo;
        this.numCadeirasLavagem = numCadeirasLavagem;
        this.numCadeirasBrushing = numCadeirasBrushing;
        this.horario = horario;
        servicosADecorrer = new ServicosContainer(new ArrayList<>());
        servicosADecorrer = servicosADecorrer.getServicosADecorrer();
        this.servicos = new ServicosContainer();
        this.funcionarios = new FuncionarioContainer();
        this.clientes = new ClienteContainer();
        this.produtos = new ProdutoContainer();
        this.criticas = new CriticaContainer();
    }

    public Cabeleireiro(String nome, String morada, double saldo, int numCadeirasLavagem, int numCadeirasBrushing, Horario horario, ServicosContainer servicosADecorrer, ServicosContainer servicos, FuncionarioContainer funcionarios, ClienteContainer clientes, ProdutoContainer produtos, CriticaContainer criticas) {
        this.nome = nome;
        this.morada = morada;
        this.saldo = saldo;
        this.numCadeirasLavagem = numCadeirasLavagem;
        this.numCadeirasBrushing = numCadeirasBrushing;
        this.horario = horario;
        this.servicosADecorrer = servicosADecorrer;
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
        servicosADecorrer = new ServicosContainer(new ArrayList<>());
        servicosADecorrer = servicosADecorrer.getServicosADecorrer();
        this.servicos = new ServicosContainer();
        this.funcionarios = new FuncionarioContainer();
        this.clientes = new ClienteContainer();
        this.produtos = new ProdutoContainer();
        this.criticas = new CriticaContainer();
    }



    public static Cabeleireiro updateCabeleireiro(Cabeleireiro arg) {
        Cabeleireiro cabeleiro = FilesOperation.load();
        cabeleiro.setNome(arg.getNome());
        cabeleiro.setMorada(arg.getMorada());
        cabeleiro.setSaldo(arg.getSaldo());
        cabeleiro.setNumCadeirasLavagem(arg.getNumCadeirasLavagem());
        cabeleiro.setNumCadeirasBrushing(arg.getNumCadeirasBrushing());
        cabeleiro.setHorario(arg.getHorario());
        return cabeleiro;
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

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumCadeirasLavagem() {
        return numCadeirasLavagem;
    }

    public void setNumCadeirasLavagem(int numCadeirasLavagem) {
        this.numCadeirasLavagem = numCadeirasLavagem;
    }

    public int getNumCadeirasBrushing() {
        return numCadeirasBrushing;
    }

    public void setNumCadeirasBrushing(int numCadeirasBrushing) {
        this.numCadeirasBrushing = numCadeirasBrushing;
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

    public void setFuncionarios(FuncionarioContainer funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ClienteContainer getClientes() {
        return clientes;
    }

    public void setClientes(ClienteContainer clientes) {
        this.clientes = clientes;
    }

    public ProdutoContainer getProdutos() {
        return produtos;
    }

    public void setProdutos(ProdutoContainer produtos) {
        this.produtos = produtos;
    }

    public ServicosContainer getServicos() {
        return servicos;
    }

    public CriticaContainer getCriticas() {
        return criticas;
    }
}
