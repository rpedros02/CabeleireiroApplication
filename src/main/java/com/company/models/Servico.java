package com.company.models;

import java.io.Serializable;

/**
 * Classe referente a um Serviço.
 */
public class Servico implements Serializable {

    private long numPedido;
    private long numCliente;
    private long numFuncionario;
    private Date dataServico;
    /**
     * Horário a que o Serviço foi efetuado. Ver {@link HorarioServico}.
     */
    private HorarioServico horarioServico;
    private ProdutoContainer produtoContainer;
    public boolean aDecorrer;

    /**
     * Construtor do Serviço.
     *
     * @param numPedido      → Número do Pedido - Int
     * @param numFuncionario
     * @param dataServico    → Data do Serviço - Date
     * @param horarioServico → Hora e Minuto do Serviço - HorarioServico
     */

    public Servico(long numPedido, long numcliente, long numFuncionario, Date dataServico, HorarioServico horarioServico, boolean aDecorrer,ProdutoContainer produtoContainer) {
        this.numPedido = numPedido;
        this.numCliente = numcliente;
        this.numFuncionario = numFuncionario;
        this.dataServico = dataServico;
        this.horarioServico = horarioServico;
        this.produtoContainer = produtoContainer;
        this.aDecorrer = aDecorrer;
    }
    /**
     * Void que encerra o Serviço caso este esteja a decorrer.
     *
     * @param servico → Serviço a encerrar.
     */
    public void encerrarServico(Servico servico) {
        servico.aDecorrer = false;
    }
    public boolean isaDecorrer(){return aDecorrer;}

    public long getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(long numPedido) {
        this.numPedido = numPedido;
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

    public long getNumCliente() {
        return numCliente;
    }
    public void setNumCliente(long numCliente) {
        this.numCliente = numCliente;
    }

    public long getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(long numFuncionario) {
        this.numFuncionario = numFuncionario;
    }


    public ProdutoContainer getProdutoContainer() {
        return produtoContainer;
    }

    public void setProdutoContainer(ProdutoContainer produtoContainer) {
        this.produtoContainer = produtoContainer;
    }
}
