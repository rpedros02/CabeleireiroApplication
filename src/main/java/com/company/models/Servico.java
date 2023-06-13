package com.company.models;

import java.io.Serializable;


public class Servico implements Serializable {

    private int numeroPedido;
    private int numeroCliente;
    private int numeroFuncionario;
    Date dataServico;
    HorarioServico horarioServico;



    public Servico(int numeroPedido, int numeroCliente, int numeroFuncionario, Date dataServico, HorarioServico horarioServico) {
        this.numeroPedido = numeroPedido;
        this.numeroCliente = numeroCliente;
        this.numeroFuncionario = numeroFuncionario;
        this.dataServico = dataServico;
        this.horarioServico = horarioServico;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public HorarioServico getHorarioServico() {
        return horarioServico;
    }

    public void setHorarioServico(HorarioServico horarioServico) {
        this.horarioServico = horarioServico;
    }
}
